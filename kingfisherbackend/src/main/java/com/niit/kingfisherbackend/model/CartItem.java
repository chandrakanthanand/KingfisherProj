
package com.niit.kingfisherbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItem 
{
	@SuppressWarnings("unused")
	private static final long SerialVersionUID=1l;
	
	@Id
	private String ci_id;
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart  cart;
	@OneToOne
	@JoinColumn(name="P_id")
	private Product Product;
	
	
	private float price;
	
	public CartItem() {
		
		this.ci_id ="CIEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCi_id() {
		return ci_id;
	}
	public void setCi_id(String ci_id) {
		this.ci_id = ci_id;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	
	
	
}
