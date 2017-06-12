package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.Card;

public interface CardDao {
	public boolean Saveorupdate(Card  card);
	public boolean delete(String card_id);
	public List<Card> getcardbyuser(String u_Id);
	public List <Card> list();

}
