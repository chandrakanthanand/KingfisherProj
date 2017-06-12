package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.CardDao;
import com.niit.kingfisherbackend.model.Card;

@Repository("cardDao")
@EnableTransactionManagement
@Transactional
public class CardDaoImpl implements CardDao{
 
	@Autowired
	SessionFactory sessionFactory;

	public CardDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean Saveorupdate(Card card) {
		sessionFactory.getCurrentSession().saveOrUpdate(card);
	    return true;
	}

	@Transactional
	public boolean delete(String card_id) {
		Card c = new Card();
		c.setCard_id(card_id);
		sessionFactory.getCurrentSession().delete(c);
		return true;
	}

	@Transactional
	public List<Card> getcardbyuser(String u_Id) {
		String q1 ="from Card where u_Id='"+u_Id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list = (List<Card>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}

	@Transactional
	public List<Card> list() {
		@SuppressWarnings("unchecked")
		List<Card> card = (List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return card;
	}
}
