package com.vijay.SportDigitalWorld.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.vijay.SportDigitalWorld.Dto.VenueResponse;

public interface AvailabilityService {

	List<VenueResponse> getAvailableVenues(String sportCode, LocalDateTime startTime, LocalDateTime endTime);
	
}
