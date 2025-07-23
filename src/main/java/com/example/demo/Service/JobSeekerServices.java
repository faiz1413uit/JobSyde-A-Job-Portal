package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Jobseeker;
import com.example.demo.Repository.JobseekerRepository;

@Service
public class JobSeekerServices {
	@Autowired
	JobseekerRepository jrepo;
	
	public  Jobseeker insertCustomer(Jobseeker JobSeeker) {
		return jrepo.save(JobSeeker);
	}
	
	public Boolean checkPhn(String phn)
	{
		return jrepo.existsByPhn(phn);
	}
	
	public List<Jobseeker> Search(String phn , String pass)
	{
		return jrepo.findByPhnAndPassword(phn, pass);
	}
	public List<Jobseeker> serviceSearch(String Jobtype, String city)
	{
		return jrepo.findByJobtypeAndCity(Jobtype,city);
	}
	public List<Jobseeker> searchByPhn(String phn)
	{
		return jrepo.findByPhn(phn);
	}
}
