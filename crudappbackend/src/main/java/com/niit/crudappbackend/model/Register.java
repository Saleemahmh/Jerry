package com.niit.crudappbackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="REGISTER")
public class Register {
	
	@Column
	public String FirstName;
	@Column
	public String LastName;
	@Column
	public String EmailId;
	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	public String UserName;
	@Transient
	public String ConfrimPassword;
	@Transient
	public String Password;
	@Column
	public String Houseno;
	@Column
	public String Street;
	@Column
	public String City;
	@Column
	public long ContactNo;
	@Column
	public String Country;
	@Column
	public long Postalcode;
	
	public Register()
	{		
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

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getConfrimPassword() {
		return ConfrimPassword;
	}

	public void setConfrimPassword(String confrimPassword) {
		ConfrimPassword = confrimPassword;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getHouseno() {
		return Houseno;
	}

	public void setHouseno(String houseno) {
		Houseno = houseno;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public long getContactNo() {
		return ContactNo;
	}

	public void setContactNo(long contactNo) {
		ContactNo = contactNo;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public long getPostalcode() {
		return Postalcode;
	}

	public void setPostalcode(long postalcode) {
		Postalcode = postalcode;
	}
	
}