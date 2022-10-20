package com.example.demo.controller;

import java.io.IOException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.gloabalException.UserNotFounfException;
import com.example.demo.model.Registration;
import com.example.demo.userRepo.RegisterRepositry;
import com.example.demo.userService.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("http://localhost:4200/")
@Slf4j
@RestController
@RequestMapping("/register")
public class RegistraionController {

	@Autowired
	RegisterService rs;
	
	@Autowired
	RegisterRepositry regisrepo;
	
	
	@PostMapping("/registercust")
	public ResponseEntity<Registration> registerCoustomer(@RequestBody Registration reg)
	{
		rs.registercust(reg);
		
		return new ResponseEntity<Registration>(reg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/logindata/{cust_email}/{password}")
	public ResponseEntity<Optional<Iterable<Registration>>> getDataByUsernameAndPassword(@PathVariable("cust_email") String cust_email,@PathVariable("password") String password)
	{
		Optional<Iterable<Registration>> list =rs.getdataforlogin(cust_email,password);
		
		return new ResponseEntity<Optional<Iterable<Registration>>>(list,HttpStatus.OK);	
	}
	
	
	
	public Optional<Registration> getDataById(int cust_id)
	{
		return regisrepo.findById(cust_id);
	}
	
	
	
	@PostMapping("/registerlogin")
	public Optional<Registration> registerlogin(@Valid @RequestBody Registration reg)
	{
		
		Registration registration =regisrepo.checkLogin(reg.getCust_email(),reg.getPassword());
		
		return  this.getDataById(registration.getCust_id());
		
	}
	
	@GetMapping("/getregdata")
	public ResponseEntity<Iterable<Registration>> getadata()
	{
			Iterable<Registration> list	=rs.getdata();
				
			return new ResponseEntity<Iterable<Registration>>(list,HttpStatus.OK);		
	}
	
	@GetMapping("/getbyid/{cust_id}")
	public ResponseEntity<Registration> getby(@PathVariable int cust_id)throws UserNotFounfException
	{
		if(cust_id!=0)
		{
				Optional<Registration> re=rs.getid(cust_id);
		
				return new ResponseEntity(re,HttpStatus.ACCEPTED);
		}
		else
		{
			throw new UserNotFounfException("Cust Id no avilable");
		}
	}
	
	
	@DeleteMapping("/delete/{cust_id}")
	public ResponseEntity<String> deletedata(@PathVariable("cust_id") int cust_id)
	{
		
		rs.deletedatabyId(cust_id);
		
		return new ResponseEntity<String>("data delete",HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}
