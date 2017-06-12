package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Product;

public interface ProductDao 
{
	public boolean saveProduct(Product Product);
	public boolean delete(String id);
	public Product getproduct(String id);
	public List<Product> getproductC(String id);
	public List<Product> list();
	public List<Product> getproductPrice();
	public List<Product> getproductPrice2();
	public List<Product> getproductPrice3();
	public List<Product> getproductPro(String Name);
	
}
