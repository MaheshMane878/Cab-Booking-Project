package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustSigninController {
	
	
	@GetMapping("/signin")
	public String signinpage()
	{
		return "login.html";
	}

}
