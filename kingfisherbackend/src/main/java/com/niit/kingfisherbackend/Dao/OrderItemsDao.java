package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.OrderItems;

public interface OrderItemsDao {
	public boolean Saveorupdate(OrderItems orderItems);
	public boolean delete(String orderItem_id);
	public OrderItems get(String orderItem_id);
	public List<OrderItems> getOrderItemsbyOrder(String order_id);
	public List <OrderItems> list();
}
