package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Seller;


public interface SellerDao 
{
	public boolean saveSeller(Seller seller);

	public boolean delete(String id);

	public Seller getSeller(String id);

	public List<Seller> list();

}
