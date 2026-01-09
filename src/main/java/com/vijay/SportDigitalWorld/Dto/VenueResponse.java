package com.vijay.SportDigitalWorld.Dto;

public class VenueResponse {

    private Long id;
    private String name;
    private String location;
    private String sportName;
    private String sportCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public String getSportCode() {
		return sportCode;
	}
	public void setSportCode(String sportCode) {
		this.sportCode = sportCode;
	}
	
	
	
	public VenueResponse(Long id, String name, String location, String sportName, String sportCode) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.sportName = sportName;
		this.sportCode = sportCode;
	}
	@Override
	public String toString() {
		return "VenueResponse [id=" + id + ", name=" + name + ", location=" + location + ", sportName=" + sportName
				+ ", sportCode=" + sportCode + "]";
	}
	public VenueResponse() {
		super();
	}
    
	
    
}