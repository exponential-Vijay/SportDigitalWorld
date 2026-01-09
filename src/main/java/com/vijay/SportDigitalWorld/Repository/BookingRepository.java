package com.vijay.SportDigitalWorld.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.SportDigitalWorld.Entity.Booking;
import com.vijay.SportDigitalWorld.Enum.BookingStatus;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	Optional<Booking> findBySlotIdAndStatus(Long slotId, BookingStatus status);
}
