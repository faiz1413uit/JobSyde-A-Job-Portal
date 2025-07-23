package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Applied;

@Repository
public interface AppliedRepository extends CrudRepository<Applied, String>{
		
	public List<Applied> findByUserphn(String userphn);
}
