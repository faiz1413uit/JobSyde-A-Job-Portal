package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.CustomerRegisteration;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository crepo;
	
	public  CustomerRegisteration insertCustomer(CustomerRegisteration customer) {
		return crepo.save(customer);
	}
	
	public Boolean checkPhn(String phn)
	{
		return crepo.existsByPhn(phn);
	}
	
	public List<CustomerRegisteration> Search(String phn , String pass)
	{
		return crepo.findByPhnAndPassword(phn, pass);
	}
	
	public Optional<CustomerRegisteration> searchByPhn(String phn)
	{
		return crepo.findById(phn);
	}
	
}
