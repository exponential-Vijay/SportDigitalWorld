package com.vijay.SportDigitalWorld.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.SportDigitalWorld.Dto.BookingResponse;
import com.vijay.SportDigitalWorld.Dto.CreateBookingRequest;
import com.vijay.SportDigitalWorld.Entity.Booking;
import com.vijay.SportDigitalWorld.Entity.Slot;
import com.vijay.SportDigitalWorld.Enum.BookingStatus;
import com.vijay.SportDigitalWorld.Exceptions.BadRequestException;
import com.vijay.SportDigitalWorld.Repository.BookingRepository;
import com.vijay.SportDigitalWorld.Repository.SlotRepository;
import com.vijay.SportDigitalWorld.Service.BookingService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired
	private SlotRepository slotRepository;
	@Autowired
	private BookingRepository bookingRepository;
	
	
	@Override
	public BookingResponse bookSlot(CreateBookingRequest request) {
		// TODO Auto-generated method stub
		
		Optional<Slot> slot = slotRepository.findByIdforUpdate(request.getSlotId());
		
		if(!slot.isPresent()) {
			throw new  BadRequestException("Provided Slot Id doest not exist.");
		} else{
			
			if(slot.get().isBooked() == true) {
				throw new BadRequestException("This Slot is already Booked, Please Select another slot to book");
			}
			
			Booking booking  = new Booking();
			
			
			booking.setSlot(slot.get());
			booking.setStatus(BookingStatus.BOOKED);
			
			Booking  savedBooking =	bookingRepository.save(booking);
					
			slot.get().setBooked(true);
			slotRepository.save(slot.get());
			return mappedBookingResponse(savedBooking);
		}
	}


	@Override
	public void cancleBooking(Long bookingId) {
		// TODO Auto-generated method stub
		
		 Optional<Booking> booking =  bookingRepository.findById(bookingId);
		 
		 if(!booking.isPresent()) {
			 throw new BadRequestException("Wrong Booking Id, this booking Id doest not exist");
		 } else {
			 
			 
			 if(booking.get().getStatus().equals(BookingStatus.CANCELLED)) {
				 throw new BadRequestException("Booking is already Cancelled");
			 }
			 
			 Slot slot = booking.get().getSlot();
			 slot.setBooked(false);
			 
			 slotRepository.save(slot);
			 
			 booking.get().setStatus(BookingStatus.CANCELLED);
		 }
		
	}
	
	public BookingResponse mappedBookingResponse(Booking b) {
		
		BookingResponse res = new BookingResponse();
		res.setBookingId(b.getId());
		res.setSlotId(b.getSlot().getId());
		res.setStatus(b.getStatus());
		return res;
	}
	
	
}
