package com.vijay.SportDigitalWorld.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.SportDigitalWorld.Dto.CreateVenueRequest;
import com.vijay.SportDigitalWorld.Dto.VenueResponse;
import com.vijay.SportDigitalWorld.Entity.Sport;
import com.vijay.SportDigitalWorld.Entity.Venue;
import com.vijay.SportDigitalWorld.Repository.SportRepository;
import com.vijay.SportDigitalWorld.Repository.VenueRepository;
import com.vijay.SportDigitalWorld.Service.VenueService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class VenueServiceImpl implements VenueService{
	
	@Autowired
	private VenueRepository venueRepository;
	@Autowired
	private SportRepository sportRepository;

	@Override
	public VenueResponse createVenue(CreateVenueRequest request) throws BadRequestException {
		
		if(venueRepository.existsByNameAndLocation(request.getName(), request.getLocation())) {
			throw new BadRequestException("Venue already exist with this name and place");
		}
		
		Optional<Sport> sport = Optional.ofNullable(new Sport());
		
			sport = sportRepository.findBySportCode(request.getSportCode());
			if(!sport.isPresent()) {
				throw new BadRequestException("Invalid Sport code");
			}
		
			Venue venue = new Venue();
			venue.setName(request.getName());
			venue.setLocation(request.getLocation());
			venue.setSport(sport.get());
			
		Venue savedVanue = venueRepository.save(venue);
		return mappedToresponse(savedVanue);
	}

	@Override
	public List<VenueResponse> getAllVenues() {

		List<Venue> allVenues = venueRepository.findAll();
		List<VenueResponse> allVenueResonses = new ArrayList<VenueResponse>();
		for(Venue v: allVenues) {
			VenueResponse vRes = mappedToresponse(v);
			allVenueResonses.add(vRes);
		}
		return allVenueResonses;
	}

	@Override
	public void deleteVenue(Long venueId) throws BadRequestException {
		Optional<Venue> venue = venueRepository.findById(venueId);
		if(!venue.isPresent()) {
			throw new BadRequestException("Provided Venue Id does not exist ");
		} else {
			venueRepository.deleteById(venueId);
			System.out.println("Venue Deleted Ho Gaya by ID  : " + venueId);
		}
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
