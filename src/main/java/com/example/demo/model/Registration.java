package com.example.demo.model;

import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cust_id;
	
	private String cust_name;
	private String cust_email;
	private String password;
	private String cust_gender;
	private String cust_age;
	private String cust_mob;
	private String marital;
	private String cust_occu;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address addr;
	
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_gender() {
		return cust_gender;
	}

	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	public String getCust_age() {
		return cust_age;
	}

	public void setCust_age(String cust_age) {
		this.cust_age = cust_age;
	}

	public String getCust_mob() {
		return cust_mob;
	}

	public void setCust_mob(String cust_mob) {
		this.cust_mob = cust_mob;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getCust_occu() {
		return cust_occu;
	}

	public void setCust_occu(String cust_occu) {
		this.cust_occu = cust_occu;
	}

	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
	
	
	

	
	
	
	
	

}
