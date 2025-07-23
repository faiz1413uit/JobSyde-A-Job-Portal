package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Applied {
	@Id
	public String phn;
	public String FirstName;
	public String LastName;
	public String jobtype;
	public String Description;
	public String city;
	
	public String userphn;
	public String rating;
	
	public Applied() {}

	public Applied(String firstName, String lastName, String jobtype, String description, String city, String phn,
			String userphn, String rating) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.jobtype = jobtype;
		Description = description;
		this.city = city;
		this.phn = phn;
		this.userphn = userphn;
		this.rating = rating;
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

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
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

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	public String getUserphn() {
		return userphn;
	}

	public void setUserphn(String userphn) {
		this.userphn = userphn;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
