package com.vijay.SportDigitalWorld.Service;

import java.util.List;

import org.apache.coyote.BadRequestException;

import com.vijay.SportDigitalWorld.Dto.CreateVenueRequest;
import com.vijay.SportDigitalWorld.Dto.VenueResponse;

public interface VenueService {

	public  VenueResponse createVenue(CreateVenueRequest request) throws BadRequestException;

    public List<VenueResponse> getAllVenues();

    public void deleteVenue(Long venueId) throws BadRequestException;
}
