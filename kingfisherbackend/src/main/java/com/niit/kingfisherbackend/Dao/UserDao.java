package com.niit.kingfisherbackend.Dao;

import java.util.List;

import com.niit.kingfisherbackend.model.User;

public interface UserDao 
{
		public boolean SaveOrUpdate(User user);
		public boolean delete(String id);
		public User getUser(String id);
		public List<User> list();
        public User isvalid(String email, String password);
        public User getUseremail(String email);
}
