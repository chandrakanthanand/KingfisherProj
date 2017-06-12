package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.CartItemDao;
import com.niit.kingfisherbackend.model.CartItem;
@Repository("cartItemDao")
@EnableTransactionManagement
public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	SessionFactory sessionFactory;

	public CartItemDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//Save method
	@Transactional
	public boolean saveCartItem(CartItem cartItem){
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	// Delete
	@Transactional
	public boolean delete(String ci_id){
		CartItem c =new CartItem();
		c.setCi_id(ci_id);
		sessionFactory.getCurrentSession().delete(c);
		return true;
	}
	
	@Transactional
	public CartItem getcartItem(String ci_id){
		String Sq= "From CartItem  where ci_id = '" +ci_id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list.get(0);
		}
		
	}
	@Transactional
	public List<CartItem> getlist(String  cart_Id) {
		String Sql= "From CartItem where cart_Id='"+  cart_Id+"'";
		Query q1= sessionFactory.getCurrentSession().createQuery(Sql);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list;
		}
	}
	@Transactional
	public List<CartItem>list()
	{
		@SuppressWarnings("unchecked")
		List<CartItem> list= (List<CartItem>)sessionFactory.getCurrentSession().createCriteria(CartItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list();
	
		
	}
	@Transactional
	public CartItem getlistall(String CartId, String pro) {
		String sql= "from CartItem where Cart_Id='" +CartId+ "'and P_Id ='" +pro+ "'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
	
	}
	@Transactional
	public List<CartItem> getlistbyproId(String p_id) {
		String Sq= "From CartItem  where P_Id='"+p_id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list;
		}
	}
}
