package com.example.demo.userRepo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Document;



@Repository
public interface DocRepositoy extends CrudRepository<Document, Integer> {
	

}
