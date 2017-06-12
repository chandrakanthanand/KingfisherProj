package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.AuthenticationDao;
import com.niit.kingfisherbackend.model.Authentication;
@Repository("authenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao{
	@Autowired
	SessionFactory sessionFactory;

	public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//Save Method
	@Transactional
		public boolean Saveorupdate(Authentication  authentication) {
		    sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		    return true;
	}

	//Delete method
	   @Transactional
		public boolean delete(String role_id) 
	   {
		   Authentication a=new  Authentication();
		   a.setRole_id("role_id");
		    sessionFactory.getCurrentSession().delete(a);
			return true;
		}

	@Transactional
	public Authentication get(String role_Id) {
		String Sq = "Form Authentication where role_id = '" + role_Id + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<Authentication> list = (List<Authentication>) q.list();
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Transactional
	public List<Authentication> list() {
		@SuppressWarnings("unchecked")
		List<Authentication> listauthentication = (List<Authentication>) sessionFactory.
		getCurrentSession().createCriteria(Authentication.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listauthentication;
	}

	

}
