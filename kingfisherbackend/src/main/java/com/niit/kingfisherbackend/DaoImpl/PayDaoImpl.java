package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.PayDao;
import com.niit.kingfisherbackend.model.Pay;

@Repository("payDao")
@EnableTransactionManagement
@Transactional
public class PayDaoImpl implements PayDao{

	@Autowired
	SessionFactory sessionFactory;

	public PayDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean Saveorupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
	    return true;
	}

	@Transactional
	public boolean delete(String pay_id) {
		Pay p = new Pay();
		p.setPay_id(pay_id);
		sessionFactory.getCurrentSession().delete(p);
		return true;
	}

	@Transactional
	public Pay get(String pay_id) {
		String q1 ="from Pay where pay_id='"+pay_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Pay> list = (List<Pay>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public List<Pay> list() {
		@SuppressWarnings("unchecked")
		List<Pay> pay = (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return pay;
	}

}
