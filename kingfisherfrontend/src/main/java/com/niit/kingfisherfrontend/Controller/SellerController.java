package com.niit.kingfisherfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.kingfisherbackend.Dao.SellerDao;
import com.niit.kingfisherbackend.model.Category;
import com.niit.kingfisherbackend.model.Seller;

@Controller
public class SellerController {
	
	@Autowired
	Seller seller;
	@Autowired
	SellerDao sellerDao;
	@RequestMapping("/seller")
	public ModelAndView sellerform() 
	{
		List<Seller> seller=sellerDao.list(); 
		ModelAndView obj = new ModelAndView("sellerform");
		obj.addObject("seller", new Seller());
		obj.addObject("sell",seller);
		return obj;
	}

@RequestMapping("/addseller")
public ModelAndView addseller(@ModelAttribute("seller")Seller seller ) {
	ModelAndView obj = new ModelAndView("redirect:/seller");
	if(sellerDao.saveSeller(seller))
	{
       obj.addObject("msg","seller is added successfuly");  		
	}
	else
	{
		obj.addObject("msg","Sorry");
	}
	return obj;
}
@RequestMapping("/edditseller/{id}")
public ModelAndView edditseller(@PathVariable("id")String id)
{
	System.out.println(123);
	List<Seller> seller=sellerDao.list();
	ModelAndView obj = new ModelAndView("sellerform");
    Seller	sel=sellerDao.getSeller(id);
    obj.addObject("seller",sel);
    obj.addObject("sell", seller);
	return obj;
	
}
@RequestMapping("/deleteseller/{id}")
public ModelAndView deleteseller(@PathVariable("id")String id)
{
	
	System.out.println(123);
	ModelAndView obj = new ModelAndView("redirect:/seller");
	if(sellerDao.delete(id))
	{
		obj.addObject("msg","category is deleted successfuly");		
	}
	else
	{
		obj.addObject("msg","category is not  deleted");
	}
	
	return obj;
	
}
}