package com.niit.kingfisherfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.kingfisherbackend.Dao.CategoryDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.model.Category;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.User;
@Controller
public class Homecontroller {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/")
	public ModelAndView entry()
	{
		
		List<Category> categories=categoryDao.list();
		ModelAndView model=new ModelAndView("index");
		model.addObject("user", new User());
		model.addObject("cat", new Category());
		model.addObject("categories",categories);
		return model;
	}
	@RequestMapping("/contactus")
	public String contact(Model model)
	{
		
		
		
		
		return "contactus";
	}
	
	@RequestMapping(value= "/allproducts")
	 public String viewproducts(Model model)
	 {
		List<Category> categories=categoryDao.list(); 
		List<Product> products=productDao.list();
		model.addAttribute("cat", new Category());
		model.addAttribute("categories",categories);
		 model.addAttribute("products", products);
		 return "allproducts";
	 }
	
	 @RequestMapping(value= "/viewpro/{id}")
	 public String viewapro(@PathVariable("id")String id, Model model)
	 {
		System.out.println(123);
		 Product p=productDao.getproduct(id);
		model.addAttribute("product",p);
		 return "singlepage";
	 }
	 @RequestMapping(value= "/view")
	 public String view(Model model)
	 {
		 return "singlepage";
	 }


}
 
