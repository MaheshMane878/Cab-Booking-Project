package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmailSend;



@Service
public class EmailService {

	@Autowired
	JavaMailSender jm;
	
	public void sendEmail(EmailSend e) {
		
		//cretate Object of SimpleMailMessage (inbuild class)
		SimpleMailMessage msg=new SimpleMailMessage();
		
		msg.setTo(e.getToEmail());
		msg.setFrom(e.getFromEmail()); 
		msg.setSubject(e.getSubject());
		msg.setText(e.getText());
		
		jm.send(msg);
		FileSystemResource f=new FileSystemResource("D:\\java\\Sum_and_big_small.java");	
			
		
	}

}
