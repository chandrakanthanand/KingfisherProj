package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Order;

public interface OrderDao {
	public boolean Saveorupdate(Order order);
	public boolean delete(String order_Id);
	public Order get(String u_Id);
	public List <Order> list();
}
