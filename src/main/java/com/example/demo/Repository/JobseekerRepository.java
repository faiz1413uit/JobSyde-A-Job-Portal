package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Jobseeker;

@Repository
public interface JobseekerRepository extends CrudRepository<Jobseeker, String> {
	public List<Jobseeker> findByPhnAndPassword(String phn, String pass);
	public Boolean existsByPhn(String phn);
	public List<Jobseeker> findByJobtypeAndCity(String Jobtype, String city);
	public List<Jobseeker> findByPhn(String phn);
}
