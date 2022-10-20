package com.example.demo.userService;

import java.util.Optional;

import com.example.demo.model.TripBooking;
import com.example.demo.userRepo.TripBookingRepository;

public interface TripBookingService {

	public TripBooking saveTripBookingData(TripBooking trip);

	public Iterable<TripBooking> getTripBookingData();

	public void updateMoney(TripBooking tripp, int tripid);

	public void deletedata(int tripid);

	

}
