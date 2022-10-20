package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gloabalException.UserIdZeroException;
import com.example.demo.model.UserDetail;
import com.example.demo.userService.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService us;
	
	
	@GetMapping("/getalldata")
	public ResponseEntity<Iterable<UserDetail>> getAlldata()
	{
		Iterable<UserDetail> list1=us.getcomData();
		
		return new ResponseEntity<Iterable<UserDetail>>(list1,HttpStatus.OK);
	}
	
	
	@GetMapping("/GetAllUserData/{userId}")
	public  ResponseEntity<Optional<UserDetail>> getData(@PathVariable("userId") int userId)throws UserIdZeroException
	{
		if(userId!=0)
		{
		Optional<UserDetail> list=us.getAllData(userId);
		
		return new ResponseEntity<Optional<UserDetail>>(list,HttpStatus.ACCEPTED);
		}
		else {
			throw new UserIdZeroException("UserId is Zero");
		}
	}
	
	
	@PostMapping("/saveData")
	public  ResponseEntity<UserDetail> submitData(@Valid @RequestBody UserDetail uerDetail)
	{
		System.out.println(uerDetail.getPassword());
		UserDetail user=us.saveData(uerDetail);
		
		return new ResponseEntity<UserDetail>(user,HttpStatus.CREATED);	
	}
	
	
	@GetMapping("/login/{username}/{password}")
	public  ResponseEntity<Optional<UserDetail>> getUsernameAndPassword(@PathVariable("username")String username,@PathVariable("password")String password)
	{
		
		Optional<UserDetail> loginData=us.loginByIDAndPassword(username,password);
		
		return new ResponseEntity<Optional<UserDetail>>(loginData,HttpStatus.OK);	
	}
	
	@PutMapping("/updateUserData/{userId}")
	public ResponseEntity<Optional<UserDetail>> updateUserData(@Valid @PathVariable("userId") int userId, @RequestBody UserDetail udd) 
	{
		
		Optional<UserDetail> ud=us.updateUserDetail(userId,udd);
		
		return new ResponseEntity<Optional<UserDetail>>(ud,HttpStatus.ACCEPTED);
				
				
		
		//return ResponseEntity<UserDetail>(ud,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/deleteById/{userId}")
	public ResponseEntity<String> deleteById(@PathVariable("userId") int userId)
	{
		
		us.deleteDataById(userId);
		
		
		return new ResponseEntity<String>("Data is Deleted",HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	
	
	
	

}
 