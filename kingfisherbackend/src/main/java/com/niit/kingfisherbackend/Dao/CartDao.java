package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Cart;

public interface CartDao {
	public boolean saveCart(Cart cart);
	public boolean delete(String id);
	public Cart getcart(String id);
	public List<Cart>list();

}
