package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.CartDao;
import com.niit.kingfisherbackend.model.Cart;
@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao{
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveCart(Cart cart){
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean delete(String id){
		Cart cart =new Cart();
		cart.setCart_id("");
		sessionFactory.getCurrentSession().delete(cart);
		return false;
	}
	@Transactional
	public Cart getcart(String cart_id){
		String Sq= "From Cart where cart_id = '"+cart_id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<Cart> list=(List<Cart>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list.get(0);
		}
		
	}

	@Transactional
	public List<Cart>list(){
		@SuppressWarnings("unchecked")
		List <Cart> listcart=(List<Cart>) sessionFactory.getCurrentSession()
		.createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listcart;
	}
}
