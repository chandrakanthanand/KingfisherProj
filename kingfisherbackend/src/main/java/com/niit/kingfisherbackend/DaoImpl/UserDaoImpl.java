package com.niit.kingfisherbackend.DaoImpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.kingfisherbackend.Dao.UserDao;
import com.niit.kingfisherbackend.model.Authentication;
import com.niit.kingfisherbackend.model.Billing;
import com.niit.kingfisherbackend.model.User;


@Repository("userDao")
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//Save method
@Transactional	
	public boolean SaveOrUpdate(User user)
	{
	Authentication authentication=new Authentication();
	authentication.setUsername(user.getU_email());
	user.getBilling().setUser(user);
	user.getBilling().setPhone(user.getU_phno());
	user.getBilling().setEmail(user.getU_email());
	sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
	sessionFactory.getCurrentSession().saveOrUpdate(user);
	sessionFactory.getCurrentSession().save(user.getCart());
	sessionFactory.getCurrentSession().saveOrUpdate(authentication);
	return true;
	
	
		
	}

//Delete method
@Transactional
    public boolean delete(String id) 
    {
	   User u =new User();
	   u.setU_Id(id);
	   sessionFactory.getCurrentSession().delete(u);
	    return true;
	}
//Edit list of User
@Transactional
	public User getUser(String id)
	{
		String q1="from User where u_id='"+id+"'";
		Query w= sessionFactory.getCurrentSession().createQuery(q1);
		List<User>list =(List<User>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
			return list.get(0);
		
	}
	
	//Entire list of User
@Transactional
	public List<User> list()
	{
		
		List<User> users= (List<User>)
				sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return users;
	}

@Transactional
public User isvalid(String email, String password)
{
	
	String q1="from User where u_email='"+email+"'and u_psw='"+password+"'";
	Query w= sessionFactory.getCurrentSession().createQuery(q1);
	List<User>list =(List<User>) w.list();
	if(list==null||list.isEmpty())
	{
		return null;
	}
	
		return list.get(0);
	
}
	
@Transactional
public User getUseremail(String email)
{
	String q1="From User where u_email='"+email+"'";
	Query w = sessionFactory.getCurrentSession().createQuery(q1);
	@SuppressWarnings("unchecked")
	List<User>list =(List<User>)w.list();
	if(list==null || list.isEmpty())
	{
		return null;
	}
	   return list.get(0);
}
}

	


