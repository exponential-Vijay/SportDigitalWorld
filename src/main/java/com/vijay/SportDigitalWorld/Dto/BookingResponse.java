package com.vijay.SportDigitalWorld.Dto;

import com.vijay.SportDigitalWorld.Enum.BookingStatus;

public class BookingResponse {

	private Long bookingId;
    private Long slotId;
    private BookingStatus status;
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
    
    
}
