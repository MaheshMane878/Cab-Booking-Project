package com.example.demo.serviceimpl;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.userRepo.RegisterRepositry;
import com.example.demo.userService.RegisterService;



@Service
public class RegisterServiceimpl implements RegisterService {

	
	@Autowired
	RegisterRepositry rr;
	
	@Override
	public Registration registercust(Registration reg) {
		
		return rr.save(reg);
	}

	@Override
	public Iterable<Registration> getdata() {
		
		return rr.findAll();
	}

	@Override
	public Optional<Registration> updateCibil(Registration reg, int cust_id) {
		
		rr.save(reg);
		
		return rr.findById(cust_id);
		
		
	}

	@Override
	public Optional<Registration> getid(int cust_id) {
		
		
		Optional<Registration> optrr=rr.findById(cust_id);
		return optrr;
	}

	@Override
	public Optional<Iterable<Registration>> getdataforlogin(String cust_email, String password) {
		
		return rr.findByCust_emailAndPassword(cust_email,password);
	}

	@Override
	public Iterable<Registration> registercustlogin(Registration reg) {
		
		return rr.findAll();
		
		
	}

	
	

}
