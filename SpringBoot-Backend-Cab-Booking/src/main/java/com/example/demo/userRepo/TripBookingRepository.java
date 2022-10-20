package com.example.demo.userRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {

}
