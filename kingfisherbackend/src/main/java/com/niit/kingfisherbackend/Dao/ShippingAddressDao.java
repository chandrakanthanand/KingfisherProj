package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.ShippingAddress;
public interface ShippingAddressDao {
	public boolean Saveorupdate(ShippingAddress shippingAddress);
	public boolean delete(String shippin_id);
	public ShippingAddress get(String shippin_id);
	public List<ShippingAddress> getaddbyuser(String u_id);
	public List <ShippingAddress> list();
}
