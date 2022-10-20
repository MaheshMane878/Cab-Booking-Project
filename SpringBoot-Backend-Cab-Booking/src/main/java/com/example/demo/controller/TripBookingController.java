package com.example.demo.controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.TripBooking;
import com.example.demo.userRepo.TripBookingRepository;
import com.example.demo.userService.TripBookingService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/trip")
public class TripBookingController {
	
	
	@Autowired
	TripBookingService ts;
	
	
	@PostMapping("/saveData")
	public ResponseEntity<TripBooking> saveTripData(@RequestBody TripBooking trip)
	{
	
		TripBooking tripdata=ts.saveTripBookingData(trip);
		
		return new ResponseEntity<TripBooking>(tripdata,HttpStatus.OK);
			
	}
	
	
	@GetMapping("/getTripBookingData")
	public Iterable<TripBooking> getTripBookingData()
	{
		
		Iterable<TripBooking> triplist=ts.getTripBookingData();
		
		return triplist;
		
	}
	
	
	
	
	@PutMapping("/updatemoney/{tripid}")
	public ResponseEntity<Integer> updateTripMoney(@RequestBody TripBooking tripp, @PathVariable("tripid") int tripid)
	{
		
		Random rmoney= new Random();
		
		int num= rmoney.nextInt(900-700)+700;//num>>600
		
		tripp.setMoney(num);// tripp >> 600
		
		ts.updateMoney(tripp,tripid); //600,id
		
		return new ResponseEntity<Integer>(num,HttpStatus.OK);
		
		
	}
	
	
	
	@DeleteMapping("/deletedata/{tripid}")
	public ResponseEntity<String> deletetripData(@PathVariable("tripid") int tripid)
	{
		
		ts.deletedata(tripid);
		
		return new ResponseEntity<String>("trip data delete",HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	

}
