package com.example.demo.controller;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gloabalException.DriverDataNotFoundException;
import com.example.demo.model.DriverDetail;
import com.example.demo.userService.DriverService;

@RestController
@RequestMapping("/driverControlldata")
public class DriverController {
	
	
	@Autowired
	DriverService ds;
	
	@GetMapping("/getAllDriverData")
	public ResponseEntity<Iterable<DriverDetail>> getallDriverData()
	{
		Iterable<DriverDetail> driverlist=ds.getAllDriverData();
		
		return  new ResponseEntity<Iterable<DriverDetail>>(driverlist,HttpStatus.OK);
	}
	
	
	@PostMapping("/savedriverdetail")
	public ResponseEntity<DriverDetail> saveDriverData(@RequestBody DriverDetail detail)
	{
		
		DriverDetail driverdetail=ds.saveDriverDetail(detail);
		
		return new ResponseEntity<DriverDetail>(driverdetail,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getdriverDatabyName/{drivername}")
	public Optional<DriverDetail> getDriverDetailByname(@PathVariable("drivername") String drivername){
			
		Optional<DriverDetail> driverData=ds.getDriverDataByName(drivername);
		
		return driverData;	
	}
	
	//long govid
	
	@GetMapping("/getdriverDatabygovid/{govid}")
	public Optional<DriverDetail> getDriverDetailBygovId(@PathVariable("govid") String govid,@RequestBody DriverDetail dd)throws DriverDataNotFoundException
	{
		
		if(dd.getGovid()==govid)
		{
		
		Optional<DriverDetail> drivergovid=ds.getDriverDataBygovid(govid);
		
		return drivergovid;	
		}
		else {
			throw new DriverDataNotFoundException("Government Id Is Invalid");
			
		}
	}
	
	
	@PutMapping("/updateDriverData/{govid}")
	public ResponseEntity<String> updateDriverDataByID(@PathVariable("govid") String govid,@RequestBody DriverDetail dd)
	{
		if(dd.getGovid()==govid)
		{
			ds.updateDataById(govid,dd);
			
			return new ResponseEntity<String>("Data is updated",HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("Id invalid",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/deleteData/{drivinglicenceno}")
	public ResponseEntity<String> deleteDriverData(@PathVariable("drivinglicenceno") String drivinglicenceno, @RequestBody DriverDetail driverDetail)throws DriverDataNotFoundException
	{
		
		if(driverDetail.getDrivinglicenceno()==drivinglicenceno)
		{
		ds.deleteDriverDataBylicenceno(drivinglicenceno);
		
		return new ResponseEntity<String>("Data is Deleted",HttpStatus.ACCEPTED);
		}
		else {
		
			throw new DriverDataNotFoundException("Ye bhava Licence No Chukla re");
		//return new ResponseEntity<String>("licence no is Invalid",HttpStatus.ACCEPTED);
		
		}	
}
}
