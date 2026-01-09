package com.vijay.SportDigitalWorld.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SlotResponse {
	private Long id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Boolean booked;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Boolean getBooked() {
		return booked;
	}
	public void setBooked(Boolean booked) {
		this.booked = booked;
	}
	public SlotResponse(Long id, LocalDateTime startTime, LocalDateTime endTime, Boolean booked) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.booked = booked;
	}
	public SlotResponse() {
		super();
	}
	
	
}
