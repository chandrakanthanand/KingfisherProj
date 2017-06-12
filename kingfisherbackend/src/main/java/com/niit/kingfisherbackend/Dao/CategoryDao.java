package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Category;

public interface CategoryDao 
{
	public boolean Savecategory(Category category);
	public boolean delete(String id);
	public Category getCategory(String id);
	public Category getCategoryp(String id);
	public List <Category> list();


}
