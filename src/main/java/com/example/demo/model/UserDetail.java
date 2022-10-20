package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 2, max = 6, message = "Name must be between 2 and 32 characters long")
	@Pattern(regexp="^[a-zA-Z0-9]*$")
	private String username;
	
	@NotEmpty(message="pass should not be empty")
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$")
	private String password;
		
	@NotEmpty(message = "mobile number should not be empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "only digit is allowed ")
    @Size(min=10,max=10,message = "number should be 10 digit ")
	private String userMob;
	
	@NotNull(message = "The date of birth is required.")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateOfBirth;

	@NotEmpty(message = "Gender is Requried")
	private String gender;
	
	@NotEmpty(message = "Email is Requried")
	@Email
	private String UserEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address useraddress;
	
	
	
	
	

	public Address getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(Address useraddress) {
		this.useraddress = useraddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", username=" + username + ", password=" + password + ", userMob="
				+ userMob + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", UserEmail=" + UserEmail + "]";
	}
	
	
	
	
	
	
	
	
}
