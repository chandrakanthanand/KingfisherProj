package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Billing;

public interface BillingDao {
	public boolean Saveorupdate(Billing billing);
	public boolean delete(String bill_id);
	public Billing get(String u_Id);
	public Billing getbilling(String bill_Id);
	public List <Billing> list();
}
