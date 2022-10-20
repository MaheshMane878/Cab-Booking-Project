package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GeneratorType;

@Entity
public class DriverDetail {
	
	
	@Id
	private String drivinglicenceno;
	
	private String drivername;
	private String adress;
	private int driverage;
	private String govid;
	private String drivermob;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address driveraddress;
	

	public Address getDriveraddress() {
		return driveraddress;
	}
	public void setDriveraddress(Address driveraddress) {
		this.driveraddress = driveraddress;
	}
	public String getDrivinglicenceno() {
		return drivinglicenceno;
	}
	public void setDrivinglicenceno(String drivinglicenceno) {
		this.drivinglicenceno = drivinglicenceno;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getGovid() {
		return govid;
	}
	public void setGovid(String govid) {
		this.govid = govid;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getDriverage() {
		return driverage;
	}
	public void setDriverage(int driverage) {
		this.driverage = driverage;
	}
	
	public String getDrivermob() {
		return drivermob;
	}
	public void setDrivermob(String drivermob) {
		this.drivermob = drivermob;
	}
	
	

}
