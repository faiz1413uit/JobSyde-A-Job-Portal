package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.CustomerRegisteration;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerRegisteration, String> {
	
	public List<CustomerRegisteration> findByPhnAndPassword(String phn, String pass);
	
	public Boolean existsByPhn(String phn);
}
