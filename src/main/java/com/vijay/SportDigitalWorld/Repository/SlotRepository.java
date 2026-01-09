package com.vijay.SportDigitalWorld.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vijay.SportDigitalWorld.Entity.Slot;
import com.vijay.SportDigitalWorld.Entity.Venue;

import jakarta.persistence.LockModeType;

public interface SlotRepository extends JpaRepository<Slot, Long>{
	
	 @Query("""
		        SELECT COUNT(s) > 0
		        FROM Slot s
		        WHERE s.venue.id = :venueId
		          AND :startTime < s.endTime
		          AND :endTime > s.startTime
		    """)
	 Boolean existsOverlappingSlot(@Param("venueId") Long venueId,
			@Param("startTime") LocalDateTime startTime,
			@Param("endTime") LocalDateTime endTime
	);
	 
	 List<Slot> findByVenueIdOrderByStartTimeAsc(Long venueId);

		@Query("""
							    SELECT DISTINCT s.venue
				FROM Slot s
				WHERE s.venue.sport.sportCode = :sportCode
				  AND s.isBooked = false
				  AND :startTime >= s.startTime
				  AND :endTime <= s.endTime
				  AND s.venue.id NOT IN (
				      SELECT s2.venue.id
				      FROM Slot s2
				      WHERE s2.isBooked = true
				        AND :startTime < s2.endTime
				        AND :endTime > s2.startTime
				  )

							""")
			List<Venue> findAvailableVenues(
			        @Param("sportCode") String sportCode,
			        @Param("startTime") LocalDateTime startTime,
			        @Param("endTime") LocalDateTime endTime
			);
		
		
		
		@Lock(LockModeType.PESSIMISTIC_WRITE)
		@Query("""
				SELECT s FROM Slot s WHERE s.id = :id
				
				""")
		Optional<Slot> findByIdforUpdate(@Param("id") Long slotId);

	 
}
