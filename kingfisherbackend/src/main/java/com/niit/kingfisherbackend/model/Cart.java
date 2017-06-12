package com.niit.kingfisherbackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Cart")
@Component
public class Cart 
{
	private static final long SerialVersionUID=1l;
	@Id
	private String cart_id;
	private double groand_total=00.0;
	private int total_item=0;
	@OneToMany(mappedBy="cart" , fetch=FetchType.EAGER)
	private List<CartItem> cartitem;
	
	
	public List<CartItem> getCartitem() {
		return cartitem;
	}
	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}
	public Cart() {
		
		this.cart_id ="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCart_id() {
		return cart_id;
	}
	public double getGroand_total() {
		return groand_total;
	}
	public void setGroand_total(double groand_total) {
		this.groand_total = groand_total;
	}
	public int getTotal_item() {
		return total_item;
	}
	public void setTotal_item(int total_item) {
		this.total_item = total_item;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	

}
