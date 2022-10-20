package com.example.demo.userService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.DriverDetail;

public interface DriverService {

	public  Iterable<DriverDetail> getAllDriverData();

	public DriverDetail saveDriverDetail(DriverDetail detail);

	public Optional<DriverDetail> getDriverDataByName(String drivername);

	public Optional<DriverDetail> getDriverDataBygovid(String govid);

	public void updateDataById(String govid, DriverDetail dd);

	public void deleteDriverDataBylicenceno(String drivinglicenceno);
	
	

}
