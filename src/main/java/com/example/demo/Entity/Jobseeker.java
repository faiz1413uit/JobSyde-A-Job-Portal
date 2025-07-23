package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Jobseeker {
	@Id
	public String AdharNo;
	public String FirstName;
	public String LastName;
	public String jobtype;
	public String Description;
	public String city;
	public String email;
	public String phn;
	public String password;
	public String rating;
	
	public String getAdharNo() {
		return AdharNo;
	}

	public void setAdharNo(String adharNo) {
		AdharNo = adharNo;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getJobType() {
		return jobtype;
	}

	public void setJobType(String jobType) {
		this.jobtype = jobType;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Jobseeker(String adharNo, String firstName, String lastName, String jobtype, String description, String city,
			String email, String phn, String password, String rating) {
		super();
		AdharNo = adharNo;
		FirstName = firstName;
		LastName = lastName;
		this.jobtype = jobtype;
		Description = description;
		this.city = city;
		this.email = email;
		this.phn = phn;
		this.password = password;
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Jobseeker() {}
}
