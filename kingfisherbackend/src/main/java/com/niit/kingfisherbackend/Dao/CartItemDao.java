package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.CartItem;

public interface CartItemDao {
	public boolean saveCartItem(CartItem cartItem);
	public boolean delete(String ci_id);
	public CartItem getcartItem(String id);
	public List<CartItem> getlist(String   cart_Id);
	public CartItem getlistall(String   CartId,String pro);
	public List<CartItem> getlistbyproId(String  p_id);
	public List<CartItem> list();

}
