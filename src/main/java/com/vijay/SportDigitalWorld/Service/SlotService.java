package com.vijay.SportDigitalWorld.Service;

import java.util.List;

import org.apache.coyote.BadRequestException;

import com.vijay.SportDigitalWorld.Dto.CreateSlotRequest;
import com.vijay.SportDigitalWorld.Dto.SlotResponse;

public interface SlotService {

	public SlotResponse createSlot(Long venueId, CreateSlotRequest slotrequest);
	public List<SlotResponse> getSlotByVenue(Long venueId);
}
