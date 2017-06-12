package com.niit.kingfisherfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.kingfisherbackend.Dao.BillingDao;
import com.niit.kingfisherbackend.Dao.UserDao;
import com.niit.kingfisherbackend.model.Billing;
import com.niit.kingfisherbackend.model.Cart;
import com.niit.kingfisherbackend.model.User;

@Controller
public class UserController {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;

	@RequestMapping("/user")
	public ModelAndView userform() 
	{
//		List<User> user=userDao.list();
		ModelAndView obj = new ModelAndView("userform");
		obj.addObject("user", new User());
		obj.addObject("users",user);
		return obj;
	}

	@RequestMapping("/adduser")
	public ModelAndView addcategory(@ModelAttribute("user")User u ) {
		ModelAndView obj = new ModelAndView("redirect:/user");
		Cart cart=new Cart();
		u.setCart(cart);
		if(userDao.SaveOrUpdate(u))
		{
	       obj.addObject("msg","user is added successfuly");  		
		}
		else
		{
			obj.addObject("msg","Sorry");
		}
		return obj;
	}
	
	

}
