package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerRegisteration {
	
	@Id
	String phn;
	String firstname;
	String lastname;
	String email;
	String address;
	String password;
	
	public CustomerRegisteration() {}
	
	public CustomerRegisteration(String phn, String firstname, String lastname, String email, String address,
			String password) {
		super();
		this.phn = phn;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
