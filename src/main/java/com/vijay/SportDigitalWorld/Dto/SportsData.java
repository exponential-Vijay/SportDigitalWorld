package com.vijay.SportDigitalWorld.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SportsData {
	
	@JsonProperty("sport_id")
	private Long sportsId;
	
	@JsonProperty("sport_code")
	private String sportsCode;
	
	@JsonProperty("sport_name")
	private String sportsName;

	public Long getSportsId() {
		return sportsId;
	}

	public void setSportsId(Long sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsCode() {
		return sportsCode;
	}

	public void setSportsCode(String sportsCode) {
		this.sportsCode = sportsCode;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	
	
	
}
