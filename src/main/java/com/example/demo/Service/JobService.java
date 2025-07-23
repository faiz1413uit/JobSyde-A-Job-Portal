package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PostJob;
import com.example.demo.Repository.PostJobRepository;

@Service
public class JobService {
	
	@Autowired
	PostJobRepository prepo;
	
	public PostJob insertJob(PostJob p)
	{
		return prepo.save(p);
	}
	 
	public Iterable<PostJob> printJob()
	{
		return prepo.findAll();
	}
	
	public List<PostJob> SearchJob(String jobtitle)
	{
		return prepo.findByJobtitleIgnoreCase(jobtitle);
	}
	
	public List<PostJob> SearchCompany(String company)
	{
		return prepo.findByCompanyIgnoreCase(company);
	}
	
	public List<PostJob> searchByno(String phn)
	{
		return prepo.findByPhn(phn);
	}
}
