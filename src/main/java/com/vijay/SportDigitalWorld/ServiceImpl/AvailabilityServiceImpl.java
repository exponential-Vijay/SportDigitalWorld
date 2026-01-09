package com.vijay.SportDigitalWorld.ServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vijay.SportDigitalWorld.Dto.VenueResponse;
import com.vijay.SportDigitalWorld.Entity.Venue;
import com.vijay.SportDigitalWorld.Exceptions.BadRequestException;
import com.vijay.SportDigitalWorld.Repository.SlotRepository;
import com.vijay.SportDigitalWorld.Repository.SportRepository;
import com.vijay.SportDigitalWorld.Service.AvailabilityService;


@Service
public class AvailabilityServiceImpl implements AvailabilityService{

	@Autowired
	private SlotRepository slotRepository;
	@Autowired
    private SportRepository sportRepository;
	
	@Override
	public List<VenueResponse> getAvailableVenues(String sportCode, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		if (startTime.isAfter(endTime) || startTime.isEqual(endTime)) {
            throw new BadRequestException("Invalid time range");
        }

        if (!sportRepository.findBySportCode(sportCode).isPresent()) {
            throw new BadRequestException("Invalid sport code");
        }
		
        
        List<Venue> venues = slotRepository.findAvailableVenues(sportCode,startTime,endTime);
        
        List<VenueResponse> venueResponses = new ArrayList<VenueResponse>();
        for(Venue v : venues) {
        	venueResponses.add(mappedToresponse(v));
        }
		return venueResponses;
	}
	
	private VenueResponse mappedToresponse(Venue venue) {
		VenueResponse venueResponse = new VenueResponse();
		venueResponse.setId(venue.getId());
		venueResponse.setName(venue.getName());
		venueResponse.setLocation(venue.getLocation());
		venueResponse.setSportName(venue.getSport().getSportName());
		venueResponse.setSportCode(venue.getSport().getSportCode());
		return venueResponse;
		
	}

}
