package com.niit.kingfisherbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product")
@Component
public class Product {
	public static final long SerialVersionUID=1l;

	@Id
	private String p_id;
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category category;
	private String p_Name;
	private float price;
	private int Que;
	@ManyToOne
	@JoinColumn(name="id")
	private Seller seller;
	@Transient
	private MultipartFile pimg;
	
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Product() {
		
		this.p_id ="PRO"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQue() {
		return Que;
	}
	public void setQue(int que) {
		Que = que;
	}
	public MultipartFile getPimg() {
		return pimg;
	}
	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}
	

}
