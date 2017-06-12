package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.BillingDao;
import com.niit.kingfisherbackend.model.Billing;

public class BillingDaoImpl implements BillingDao {
	@Autowired
	SessionFactory sessionFactory;

	public BillingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean Saveorupdate(Billing billing)
	{
	    sessionFactory.getCurrentSession().saveOrUpdate(billing);
	    return true;
	}
	@Transactional
	public boolean delete(String bill_id)
	{
		Billing b = new Billing();
		b.setBill_id(bill_id);
		sessionFactory.getCurrentSession().delete(b);
		return true;
	}
	@Transactional
	public Billing get(String u_Id)
	{
		String q1 ="from Billing where u_Id='"+u_Id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Billing> list = (List<Billing>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	@Transactional
	public List <Billing> list()
	{
		@SuppressWarnings("unchecked")
		List<Billing> bill = (List<Billing>) sessionFactory.getCurrentSession().createCriteria(Billing.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return bill;
	}
	@Transactional
	public Billing getbilling(String bill_Id) {
		String q1 ="from Billing where bill_Id='"+bill_Id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Billing> list = (List<Billing>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	}

