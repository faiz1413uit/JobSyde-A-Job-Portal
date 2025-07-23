package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostJob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String jobtitle;
	public String company;
	public String type;
	public String location;
	public String experience;
	public String salary;
	public String description;
	public String phn;
	
	public PostJob() {}

	

	public PostJob(String jobtitle, String company, String type, String location, String experience, String salary,
			String description, String phn) {
		super();
		this.jobtitle = jobtitle;
		this.company = company;
		this.type = type;
		this.location = location;
		this.experience = experience;
		this.salary = salary;
		this.description = description;
		this.phn = phn;
	}



	public String getPhn() {
		return phn;
	}



	public void setPhn(String phn) {
		this.phn = phn;
	}



	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}