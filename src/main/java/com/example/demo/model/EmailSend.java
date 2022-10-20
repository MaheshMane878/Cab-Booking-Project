package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailSend {
	
	
	private String toEmail;
	private String fromEmail;
	private String subject;
	private String text;
	
	
	
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
	

}
