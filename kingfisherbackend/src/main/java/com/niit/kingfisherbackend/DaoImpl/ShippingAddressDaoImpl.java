package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.ShippingAddressDao;
import com.niit.kingfisherbackend.model.ShippingAddress;


@Repository("shippingAddressDao")
@EnableTransactionManagement
@Transactional
public class ShippingAddressDaoImpl implements ShippingAddressDao {

	@Autowired
	SessionFactory sessionFactory;

	public ShippingAddressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean Saveorupdate(ShippingAddress shippingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
	    return true;
	}

	@Transactional
	public boolean delete(String shippin_id) {
		ShippingAddress s = new ShippingAddress();
		s.setShippin_id(shippin_id);
		sessionFactory.getCurrentSession().delete(s);
		return true;
	}

	@Transactional
	public ShippingAddress get(String shippin_id) {
		String q1 ="from ShippingAddress where shippin_id='"+shippin_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<ShippingAddress> list = (List<ShippingAddress>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public List<ShippingAddress> getaddbyuser(String u_id) {
		String q1 ="from ShippingAddress where u_id='"+u_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<ShippingAddress> list = (List<ShippingAddress>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
		}

	@Transactional
	public List<ShippingAddress> list() {
		@SuppressWarnings("unchecked")
		List<ShippingAddress> s = (List<ShippingAddress>) sessionFactory.getCurrentSession().createCriteria(ShippingAddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return s;
	}
}
