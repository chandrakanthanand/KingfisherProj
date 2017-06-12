package com.niit.kingfisherbackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.Seller;
import com.niit.kingfisherbackend.model.User;


@Repository("productDao")
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Transactional
	public boolean delete(String id) {
		Product p = new Product();
		p.setP_id(id);
		sessionFactory.getCurrentSession().delete(p);
		return true;
	}

	@Transactional
	public Product getproduct(String id) {
		String q1 = "from Product where P_id='"+id +"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list.get(0);
		
	    }
	@Transactional
	public List<Product> getproductC(String id) {
		String q1 = "from Product where cat_id='"+id+"'";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }
	@Transactional
	public List<Product> getproductPro(String Name) {
		String q1 = "from Product where P_Name='"+Name+"'";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }


	@Transactional
	public List<Product> getproductPrice() {
		String q1 = "from Product where price between 100 and 500";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }
	@Transactional
	public List<Product> getproductPrice2() {
		String q1 = "from Product where price between 500 and 1000";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }
	@Transactional
	public List<Product> getproductPrice3() {
		String q1 = "from Product where price between 1000 and 2000";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }
	@Transactional
	public List<Product> list() {
		List<Product> products = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return products;

		
	}

	
}
