package com.niit.kingfisherbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table 
@Component
public class Pay {
	@Id
	  private String pay_id;
	  private String pay_may;
	  private String status;
	  
	public Pay() 
	{
		this.pay_id = "PAY"+UUID.randomUUID().toString().substring(30).toUpperCase();

	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getPay_may() {
		return pay_may;
	}
	public void setPay_may(String pay_may) {
		this.pay_may = pay_may;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	  

}
