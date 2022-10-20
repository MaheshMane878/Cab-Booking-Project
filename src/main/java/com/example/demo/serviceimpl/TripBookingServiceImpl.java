package com.example.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.TripBooking;
import com.example.demo.userRepo.TripBookingRepository;
import com.example.demo.userService.TripBookingService;

@Service
public class TripBookingServiceImpl implements TripBookingService {
	
	@Autowired
	TripBookingRepository tbr;

	@Override
	public TripBooking saveTripBookingData(TripBooking trip) {
		
		return tbr.save(trip);
	}

	@Override
	public Iterable<TripBooking> getTripBookingData() {
		
		return tbr.findAll();
	}

	@Override
	public void updateMoney(TripBooking tripp, int tripid) {
		
		Optional<TripBooking> trip=tbr.findById(tripid);
		TripBooking tb= trip.get();
		tb.setMoney(tripp.getMoney());
		tbr.save(tb);
		
		
	}

	
	
	
	
	

}
