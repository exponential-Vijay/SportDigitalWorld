package com.vijay.SportDigitalWorld.Dto;

import javax.validation.constraints.NotBlank;

public class CreateVenueRequest {

	@NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotBlank
    private String sportCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSportCode() {
		return sportCode;
	}

	public void setSportCode(String sportCode) {
		this.sportCode = sportCode;
	}
    
    
}

