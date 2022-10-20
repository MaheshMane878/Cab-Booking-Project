package com.example.demo.serviceimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.DriverDetail;
import com.example.demo.userRepo.DriverRepository;
import com.example.demo.userService.DriverService;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
	
	
	@Autowired
	DriverRepository dr;

	@Override
	public Iterable<DriverDetail> getAllDriverData() {
		
		return dr.findAll();
	}

	@Override
	public DriverDetail saveDriverDetail(DriverDetail detail) {
		
		return dr.save(detail);
	}

	@Override
	public Optional<DriverDetail> getDriverDataByName(String drivername) {
		
		return dr.findByDrivername(drivername);
	}

	@Override
	public Optional<DriverDetail> getDriverDataBygovid(String govid) {
		
		return dr.findDataByDriverGovid(govid);
	}

	@Override
	public void updateDataById(String govid,DriverDetail dd) {
		
		dr.findDataByDriverGovid(govid);
		dr.save(dd);		
	}

	@Override
	public void deleteDriverDataBylicenceno(String drivinglicenceno) {
		// TODO Auto-generated method stub
		
		dr.deleteDataBydrivinglicenceno(drivinglicenceno);
		
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
