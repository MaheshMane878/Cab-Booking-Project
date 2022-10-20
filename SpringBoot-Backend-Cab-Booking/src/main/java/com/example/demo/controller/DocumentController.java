package com.example.demo.controller;


import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Document;
import com.example.demo.userService.DocService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@CrossOrigin("*")
@RestController
public class DocumentController {
	
	
	@Autowired
	DocService ds;
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Iterable<Document> uploaddoc(@RequestPart(required = true,value = "addrproof")MultipartFile fiels1,
			
			@RequestPart(required = true,value ="adhharcard")MultipartFile fiels2,
			@RequestPart(required = true,value ="pancard")MultipartFile fiels3,
			@RequestPart(required = true,value ="photo")MultipartFile fiels4,
			@RequestPart(required = true, value ="sign")MultipartFile fiels5,
			
			@RequestPart("doc") String doc)throws IOException{
		
		
			Document d=new Document();
				
				d.setAddrproof(fiels1.getBytes());
				d.setAdhharcard(fiels2.getBytes());
				d.setPancard(fiels3.getBytes());
				d.setPhoto(fiels4.getBytes());
				d.setSign(fiels5.getBytes());
					
				ObjectMapper obj=new ObjectMapper();
				
					Document dd =obj.readValue(doc,Document.class);
				
					d.setCust_id(dd.getCust_id());
					
						Iterable<Document>	list = ds.savedata(d);
			
			return list;	
			
	}
	
	
	@GetMapping("/getdoc")
	public Iterable<Document> getdata()
	{
		
				Iterable<Document> list1 =ds.displayall();
				
				return list1;	
	}
	
	

}
