package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.OrderItemsDao;
import com.niit.kingfisherbackend.model.OrderItems;

@Repository("orderItemsDao")
@EnableTransactionManagement
@Transactional
public class OrderItemsDaoImpl implements OrderItemsDao{

	@Autowired
	SessionFactory sessionFactory;

	public OrderItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean Saveorupdate(OrderItems orderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
	    return true;
	}

	@Transactional
	public boolean delete(String orderItem_id) {
		OrderItems oi = new OrderItems();
		oi.setOrderItem_id(orderItem_id);
		sessionFactory.getCurrentSession().delete(oi);
		return true;
	}

	@Transactional
	public OrderItems get(String orderItems_id) {
		String q1 ="from OrderItems where orderItems_id='"+orderItems_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list = (List<OrderItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public List<OrderItems> getOrderItemsbyOrder(String order_id) {
		String q1 ="from OrderItems where order_id='"+order_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list = (List<OrderItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}

	@Transactional
	public List<OrderItems> list() {
		@SuppressWarnings("unchecked")
		List<OrderItems> orderitems = (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderitems;
	}
}
