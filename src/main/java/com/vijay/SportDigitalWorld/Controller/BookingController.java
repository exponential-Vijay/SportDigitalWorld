package com.vijay.SportDigitalWorld.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.SportDigitalWorld.Dto.BookingResponse;
import com.vijay.SportDigitalWorld.Dto.CreateBookingRequest;
import com.vijay.SportDigitalWorld.Service.BookingService;

@RestController
@RequestMapping("/bookings")
@Validated
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<BookingResponse> bookSlot(@RequestBody @Validated CreateBookingRequest request){
		
		BookingResponse resp = bookingService.bookSlot(request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(resp);
	}
	
	@PostMapping("/{id}/cancel")
	public ResponseEntity<String> cancleBooking(@PathVariable Long id){
		
		bookingService.cancleBooking(id);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Cancelled");
	}
	
}
