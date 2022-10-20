package com.example.demo.userRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DriverDetail;


@Repository
public interface DriverRepository extends JpaRepository<DriverDetail,String> {
	
	
	public Optional<DriverDetail> findByDrivername(String drivername);
	
	public Optional<DriverDetail> findByGovid(String govid);
	
	
	//long govid

//	@Modifying
//	@Query("select d from DriverDetail d where d.govid =:govid")
//	public Optional<DriverDetail> findDataByDriverGovid(@Param("govid") long govid);
//	
	
	
	
	
@Query("SELECT em FROM DriverDetail em WHERE em.govid = :govid")
public Optional<DriverDetail> findDataByDriverGovid(@Param("govid") String govid);



@Modifying
@Query("delete from DriverDetail u where u.drivinglicenceno = :drivinglicenceno")
public void deleteDataBydrivinglicenceno(@Param("drivinglicenceno") String drivinglicenceno);













	
	
	
	
	

}
