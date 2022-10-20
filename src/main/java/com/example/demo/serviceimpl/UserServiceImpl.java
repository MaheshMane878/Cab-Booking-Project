package com.example.demo.serviceimpl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.controller.UserController;
import com.example.demo.model.UserDetail;
import com.example.demo.userRepo.UserRepository;
import com.example.demo.userService.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository ur;

	@Override
	public Optional<UserDetail> getAllData(int userId) {
		
		return ur.findById(userId);
	}

	@Override
	public UserDetail saveData(UserDetail uerDetail) {
	
	return	ur.save(uerDetail);
		
	}

	@Override
	public Optional<UserDetail> loginByIDAndPassword(@Valid String username, String password) {
		
		
		
		return ur.findByUsernameAndPassword(username, password);
	}

	@Override
	public Optional<UserDetail> updateUserDetail(@Valid @PathVariable int userId, @RequestBody UserDetail udd) {
		
		ur.save(udd);
		
		return ur.findByUserId(userId);
	}

	@Override
	public void deleteDataById(int userId) {
		
		ur.deleteById(userId);
	}

	@Override
	public Iterable<UserDetail> getcomData() {
		
		return ur.findAll();
		
	}

	

	

	

	
	
	

}
