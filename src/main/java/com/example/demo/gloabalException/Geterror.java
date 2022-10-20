package com.example.demo.gloabalException;



import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Geterror {
	
	private int status;
	private HttpStatus error;
	private String message;
	private Date date;
	private String path;
	
	public Geterror(int status, HttpStatus error, String message, Date date, String path) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.date = date;
		this.path = path;
	}
	
	
	
	
	

}
