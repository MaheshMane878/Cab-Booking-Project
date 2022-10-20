package com.example.demo.userService;

import java.util.Optional;

import com.example.demo.model.Registration;




public interface RegisterService {

 public	Registration registercust(Registration reg);

public Iterable<Registration> getdata();

public Optional<Registration> updateCibil(Registration reg, int cust_id);

public Optional<Registration> getid(int cust_id);

public Optional<Iterable<Registration>> getdataforlogin(String cust_email, String password);

public Iterable<Registration> registercustlogin(Registration reg);




	

}
