package com.niit.kingfisherbackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")
@Component
public class Category 
{
	private static final long SerialVersionUID=1l;
	@Id
	private String cat_id;
	private String cat_name;
	private String cat_des;
	@OneToMany(mappedBy="category")
	private List<Product> product;
	public Category() {
		this.cat_id="CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCat_id() {
		return cat_id;
	}
	
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getCat_des() {
		return cat_des;
	}
	public void setCat_des(String cat_des) {
		this.cat_des = cat_des;
	}
	
	
	

}
