package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Pay;

public interface PayDao {
	public boolean Saveorupdate(Pay pay);
	public boolean delete(String pay_id);
	public Pay get(String pay_id);
	public List <Pay> list();
}
