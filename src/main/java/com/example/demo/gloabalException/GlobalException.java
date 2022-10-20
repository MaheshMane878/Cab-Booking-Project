package com.example.demo.gloabalException;

import java.util.Date;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalException {
	
	@ExceptionHandler(UserIdZeroException.class)
	public ResponseEntity<Geterror> usernotfoundhandle(UserIdZeroException e,HttpServletRequest hs)
	{
		
		Geterror error=new Geterror(HttpStatus.NOT_ACCEPTABLE.value(),HttpStatus.BAD_REQUEST,e.getMessage(),new Date(),hs.getRequestURI());
		
		
		return new ResponseEntity<Geterror>(error,HttpStatus.NOT_FOUND);
	}
	
	
//	
//	@ExceptionHandler(DriverDataNotFoundException.class)
//	public ResponseEntity<Geterror> usernotfoundhandle(DriverDataNotFoundException e,HttpServletRequest hs)
//	{
//		
//		Geterror error=new Geterror(HttpStatus.NOT_ACCEPTABLE.value(),HttpStatus.BAD_REQUEST,e.getMessage(),new Date(),hs.getRequestURI());
//		
//		
//		return new ResponseEntity<Geterror>(error,HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(UserNotFounfException.class)
	public ResponseEntity<Geterror> usernotfoundhandle(UserNotFounfException e,HttpServletRequest hs)
	{
		
		Geterror error=new Geterror(HttpStatus.NOT_FOUND.value(),HttpStatus.BAD_REQUEST,e.getMessage(),new Date(),hs.getRequestURI());
		
		
		return new ResponseEntity<Geterror>(error,HttpStatus.NOT_FOUND);
	}
	
	
	
}
