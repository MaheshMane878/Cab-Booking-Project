package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmailSend;
import com.example.demo.serviceimpl.EmailService;

@CrossOrigin("*")
@RestController
public class EmailController {

	@Autowired
	EmailService hs;
	
	@Value("${spring.mail.username}")
	private String formEmail;
	
	@PostMapping("/emailsend")
	public String sendEmail(@RequestBody EmailSend e)
	{
		e.setFromEmail(formEmail);
		
		try {
			
			hs.sendEmail(e);
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
			
			return "Email not send";	
		}
		
		return "Email Send";	
	}
	
	
	
	
	
	
	
	
	
}
