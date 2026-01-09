package com.vijay.SportDigitalWorld.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.SportDigitalWorld.Dto.CreateSlotRequest;
import com.vijay.SportDigitalWorld.Dto.SlotResponse;
import com.vijay.SportDigitalWorld.Entity.Slot;
import com.vijay.SportDigitalWorld.Entity.Venue;
import com.vijay.SportDigitalWorld.Repository.SlotRepository;
import com.vijay.SportDigitalWorld.Repository.VenueRepository;
import com.vijay.SportDigitalWorld.Service.SlotService;

@Service
public class SlotServiceImpl implements SlotService{

	@Autowired
	private SlotRepository slotRepository;
	
	@Autowired
	private VenueRepository venueRepository;
	
	@Override
	public SlotResponse createSlot(Long venueId, CreateSlotRequest slotrequest) {

		if(slotrequest.getStartTime().isAfter(slotrequest.getEndTime()) || slotrequest.getStartTime().isEqual(slotrequest.getEndTime())) {
			throw new com.vijay.SportDigitalWorld.Exceptions.BadRequestException("Slot Start time should be before End time");
		}
		
		Optional<Venue> venue = venueRepository.findById(venueId);
		if(!venue.isPresent()) {
			throw new com.vijay.SportDigitalWorld.Exceptions.BadRequestException("Provided Venue Id not found");
		}
		
		boolean overlapping = slotRepository.existsOverlappingSlot(venueId, slotrequest.getStartTime(), slotrequest.getEndTime());
		if(overlapping) {
			throw new com.vijay.SportDigitalWorld.Exceptions.BadRequestException("Slot time Overlaps with existing slots for the venue");
		}
		
		Slot slot = new Slot();
		slot.setStartTime(slotrequest.getStartTime());
		slot.setEndTime(slotrequest.getEndTime());
		slot.setVenue(venue.get());
		slot.setBooked(false);
		slotRepository.save(slot);
		return MapSlotResponse(slot);
	
	}


	@Override
	public List<SlotResponse> getSlotByVenue(Long venueId){
		// TODO Auto-generated method stub
		if(!venueRepository.existsById(venueId)) {
//			throw new BadRequestException("Provided Venue Id does not exist");
			throw new com.vijay.SportDigitalWorld.Exceptions.BadRequestException("Provided Venue Id does not exist");
		}
		
		List<Slot> Slots = slotRepository.findByVenueIdOrderByStartTimeAsc(venueId);
		
		return Slots.stream().map(s -> MapSlotResponse(s)).toList();
	}

	private SlotResponse MapSlotResponse(Slot slot) {
		SlotResponse sResponse = new SlotResponse();
		 sResponse.setBooked(slot.isBooked());
		 sResponse.setStartTime(slot.getStartTime());
		 sResponse.setEndTime(slot.getEndTime());
		 sResponse.setId(slot.getId());
		 
		return sResponse;
	}
}
