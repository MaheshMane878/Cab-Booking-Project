package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	private String house_no;
	private String area;
	private String acity;
	private String talq;
	private int pincode;
	private String Sta;
	private String Count;
	
	
	public String getSta() {
		return Sta;
	}
	public void setSta(String sta) {
		Sta = sta;
	}
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getHouse_no() {
		return house_no;
	}
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAcity() {
		return acity;
	}
	public void setAcity(String acity) {
		this.acity = acity;
	}
	public String getTalq() {
		return talq;
	}
	public void setTalq(String talq) {
		this.talq = talq;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	

}
