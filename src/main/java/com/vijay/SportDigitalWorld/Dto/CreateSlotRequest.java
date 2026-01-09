package com.vijay.SportDigitalWorld.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class CreateSlotRequest {

	@NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public CreateSlotRequest(@NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public CreateSlotRequest() {
		super();
	}
    
}
