
	package com.niit.kingfisherbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class ShippingAddress 
{
	 @Id
	  private String Shippin_id;
	  private String houseno;
	  private String country;
	  private String city;
	  private String pincode;
	  private String email;
	  private String mono;
	  private String firstname;
	  private String lastname;
	  @ManyToOne
	  @JoinColumn(name="u_Id")
	  User user;
	  
	  
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ShippingAddress() {
		Shippin_id = "Shippin"+UUID.randomUUID().toString().toString().substring(30).toUpperCase();
	}
	public String getShippin_id() {
		return Shippin_id;
	}
	public void setShippin_id(String shippin_id) {
		Shippin_id = shippin_id;
	}
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMono() {
		return mono;
	}
	public void setMono(String mono) {
		this.mono = mono;
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
	  
	  
}
