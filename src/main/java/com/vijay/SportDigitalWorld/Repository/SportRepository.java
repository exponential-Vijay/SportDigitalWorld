package com.vijay.SportDigitalWorld.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.SportDigitalWorld.Entity.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
	
	
	Optional<Sport> findBySportCode(String sportCode);
}
