package com.niit.kingfisherbackend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.niit.kingfisherbackend.Dao.CartItemDao;
import com.niit.kingfisherbackend.DaoImpl.CartItemDaoImpl;

@Entity
@Table(name="User")
@Component
public class User {
	public static final long SerialVersionUID=1l;

	@Id
	private String u_Id;
	private String u_name;
	private String u_gender;
//	private String u_add;
	private String u_phno;
	private String u_email;
	private String u_psw;
	private String role="ROLE_USER";
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bill_id")
	private Billing billing;
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getU_Id() {
		return u_Id;
	}
	public User() {
		
		this.u_Id ="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public void setU_Id(String u_Id) {
		this.u_Id = u_Id;
	}
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
//	public String getU_add() {
//		return u_add;
//	}
//	public void setU_add(String u_add) {
//		this.u_add = u_add;
//	}
	public String getU_phno() {
		return u_phno;
	}
	public void setU_phno(String u_phno) {
		this.u_phno = u_phno;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_psw() {
		return u_psw;
	}
	public void setU_psw(String u_psw) {
		this.u_psw = u_psw;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
		
	
	}
	