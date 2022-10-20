package com.example.demo.gloabalException;

import net.bytebuddy.implementation.bind.annotation.Super;

public class DriverDataNotFoundException extends Exception {
	
	public DriverDataNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

}
