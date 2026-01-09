package com.vijay.SportDigitalWorld.Controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.SportDigitalWorld.Dto.CreateVenueRequest;
import com.vijay.SportDigitalWorld.Dto.VenueResponse;
import com.vijay.SportDigitalWorld.Service.VenueService;

@RestController
@RequestMapping("/venues")
@Validated
public class VenueController {
	
	@Autowired
	private VenueService venueService;
	
	@PostMapping
	public ResponseEntity<VenueResponse> createVenue(@RequestBody CreateVenueRequest venueRequest) {
		try {
			VenueResponse venueResponse = venueService.createVenue(venueRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(venueResponse);
		} catch (BadRequestException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new VenueResponse());
	}
	
	@GetMapping
	public ResponseEntity<List<VenueResponse>> getAllVenues(){
		List<VenueResponse> respone = venueService.getAllVenues();
		
		return ResponseEntity.status(HttpStatus.OK).body(respone);
		
	}
	
	@DeleteMapping("/{venueId}")
	public ResponseEntity<String> deleteVenue(@PathVariable Long venueId){
		try {
			venueService.deleteVenue(venueId);
			return ResponseEntity.status(HttpStatus.OK).body("Success") ;
		} catch (BadRequestException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()) ;
		}
		
	}

}
