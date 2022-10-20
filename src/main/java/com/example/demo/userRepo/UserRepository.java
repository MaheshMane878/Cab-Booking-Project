package com.example.demo.userRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail,Integer> {

	
	
	public Optional<UserDetail> findByUsernameAndPassword(String username,String password);
	
	public Optional<UserDetail> findByUserId(int userId);
	
}
