package com.vijay.SportDigitalWorld.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.SportDigitalWorld.Dto.VenueResponse;
import com.vijay.SportDigitalWorld.Service.AvailabilityService;

@RestController
@RequestMapping("/venues/available")
public class AvailabilityController {

	
	@Autowired
	private AvailabilityService availabilityService;
	
	@GetMapping
	public ResponseEntity<List<VenueResponse>> getAvailableVenues(@RequestParam String sportCode,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
		
		List<VenueResponse> available = availabilityService.getAvailableVenues(sportCode, startTime, endTime);

		return ResponseEntity.status(HttpStatus.OK).body(available);
		
	}
}
