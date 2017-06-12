package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Authentication;

public interface AuthenticationDao {
	public boolean Saveorupdate(Authentication authentication);
	public boolean delete(String role_Id);
	public Authentication get(String role_id);
	public List <Authentication> list();

}
