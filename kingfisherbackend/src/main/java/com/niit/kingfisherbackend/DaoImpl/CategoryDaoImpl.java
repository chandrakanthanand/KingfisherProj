package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.CategoryDao;
import com.niit.kingfisherbackend.model.Category;


@Repository("categoryDao")
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean Savecategory(Category category)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}
	@Transactional
	public boolean delete(String id){
		Category cat= new Category();
		cat.setCat_id(id);
		sessionFactory.getCurrentSession().delete(cat);
		return true;
	}
	@Transactional
	public Category getCategory(String id){
		String q1 = "from Category where cat_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Category> list = (List<Category>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list.get(0);
	   }
	@Transactional
	public Category getCategoryp(String id){
		String q1 = "from Product where cat_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Category> list = (List<Category>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list.get(0);
	   }
	
	@Transactional
	public List <Category> list(){
		List<Category> categorys = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return categorys;

		
	}

}
