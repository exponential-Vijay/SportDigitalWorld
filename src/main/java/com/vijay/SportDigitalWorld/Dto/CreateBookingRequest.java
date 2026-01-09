package com.vijay.SportDigitalWorld.Dto;

import javax.validation.constraints.NotNull;

public class CreateBookingRequest {

	@NotNull
	private Long slotId;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	
}
