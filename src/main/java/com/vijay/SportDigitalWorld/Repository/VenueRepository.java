package com.vijay.SportDigitalWorld.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.SportDigitalWorld.Entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long>{
	
	boolean existsByNameAndLocation(String name, String location);
}
