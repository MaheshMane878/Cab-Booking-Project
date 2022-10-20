package com.example.demo.userService;

import java.util.Optional;

import com.example.demo.controller.UserController;
import com.example.demo.model.UserDetail;

public interface UserService {

	public Optional<UserDetail> getAllData(int userId);

	

	public UserDetail saveData(UserDetail uerDetail);



	public Optional<UserDetail> loginByIDAndPassword(String username, String password);



	public Optional<UserDetail> updateUserDetail(int userId, UserDetail udd);



	public void deleteDataById(int userId);



	public Iterable<UserDetail> getcomData();



	





}
