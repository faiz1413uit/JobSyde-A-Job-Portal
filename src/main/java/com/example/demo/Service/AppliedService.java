package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Applied;
import com.example.demo.Repository.AppliedRepository;

@Service
public class AppliedService {

	@Autowired
	AppliedRepository arepo;
	
	public Applied insert(Applied a)
	{
		return arepo.save(a);
	}
	
	public Iterable<Applied> findApplication()
	{
		return arepo.findAll();
	}
	
	public List<Applied> findUser(String phn){
		return arepo.findByUserphn(phn);
	}
}
