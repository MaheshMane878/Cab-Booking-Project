package com.example.demo.userRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Registration;



@Repository
public interface RegisterRepositry extends JpaRepository<Registration,Integer> {
	
//	@Modifying
//	@Query("select u from registration u where u.custemail = :custemail and u.password = :password")
	
	
	public Optional<Registration> findByPassword(String password);
	
	@Query(value = "SELECT * FROM Registration WHERE cust_email = ?1 AND password = ?2", nativeQuery = true)
    public Registration checkLogin(String cust_email, String password);
	
	
	@Modifying
    @Query("select r from Registration r where r.cust_email = :cust_email and r.password = :password")
	Optional<Iterable<Registration>> findByCust_emailAndPassword(@Param("cust_email") String cust_email,@Param("password") String password);
	
	
	
	
	@Modifying
	@Query("delete from Registration u where u.cust_id = :cust_id")
	public void deleteByCust_id(@Param("cust_id") int cust_id);


	
	
	
	
	
	
	
	
}
