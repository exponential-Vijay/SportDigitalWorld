package com.vijay.SportDigitalWorld.Controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.SportDigitalWorld.Dto.CreateSlotRequest;
import com.vijay.SportDigitalWorld.Dto.SlotResponse;
import com.vijay.SportDigitalWorld.Service.SlotService;

@RestController
@RequestMapping("/venues/{venueId}/slots")
@Validated
public class SlotContraoller {
	
	@Autowired
	private SlotService slotService;
	
	@PostMapping
	public ResponseEntity<?> createSlot(@PathVariable Long venueId, @RequestBody CreateSlotRequest slotRequest) {
		
			SlotResponse resp = slotService.createSlot(venueId, slotRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(resp);
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<SlotResponse>> getSlotsForVenue(@PathVariable Long venueId){
			List<SlotResponse> slots =  slotService.getSlotByVenue(venueId);
			return ResponseEntity.status(HttpStatus.OK).body(slots);
	
	}
	

}
