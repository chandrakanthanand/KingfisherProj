package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.OrderDao;
import com.niit.kingfisherbackend.model.Order;

@Repository("orderDao")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean Saveorupdate(Order order) {
		sessionFactory.openSession().saveOrUpdate(order);
	    return true;
	}

	@Transactional
	public boolean delete(String order_Id) {
		Order o = new Order();
		o.setOrder_Id(order_Id);
		sessionFactory.openSession().delete(o);
		return true;
	}

	@Transactional
	public Order get(String u_Id) {
		String q1 ="from Order where u_Id='"+u_Id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Order> list = (List<Order>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public List<Order> list() {
		@SuppressWarnings("unchecked")
		List<Order> order = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return order;
	}

}
