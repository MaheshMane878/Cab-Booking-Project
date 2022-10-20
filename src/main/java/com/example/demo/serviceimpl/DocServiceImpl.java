package com.example.demo.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Document;
import com.example.demo.userRepo.DocRepositoy;
import com.example.demo.userService.DocService;

@Service
public class DocServiceImpl implements DocService
{

		
		@Autowired
		DocRepositoy dr;

		@Override
		public Iterable<Document> savedata(Document dd) {
			dr.save(dd);
			return dr.findAll();
		}

		@Override
		public Iterable<Document> displayall() {
			
			return dr.findAll();
		}


	

}
