package com.vijay.SportDigitalWorld.Service;

import com.vijay.SportDigitalWorld.Dto.BookingResponse;
import com.vijay.SportDigitalWorld.Dto.CreateBookingRequest;

public interface BookingService {

	BookingResponse bookSlot(CreateBookingRequest request);
	
	void cancleBooking(Long bookingId);
}
