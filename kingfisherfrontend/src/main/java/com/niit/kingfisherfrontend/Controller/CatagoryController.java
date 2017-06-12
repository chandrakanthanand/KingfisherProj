package com.niit.kingfisherfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.kingfisherbackend.Dao.CategoryDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.model.Category;
import com.niit.kingfisherbackend.model.Product;

@Controller
public class CatagoryController {
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@RequestMapping("/category")
	public ModelAndView categoryform() 
	{
		List<Category> categories=categoryDao.list(); 
		ModelAndView obj = new ModelAndView("catagoryform");
		obj.addObject("cat", new Category());
		obj.addObject("categories",categories);
		return obj;
	}

	@RequestMapping("/addcategory")
	public ModelAndView addcategory(@ModelAttribute("category")Category category ) {
		ModelAndView obj = new ModelAndView("redirect:/category");
		if(categoryDao.Savecategory(category))
		{
	       obj.addObject("msg","category is added successfuly");  		
		}
		else
		{
			obj.addObject("msg","Sorry");
		}
		return obj;
	}
	@RequestMapping("/edditcategory/{Cat_id}")
	public ModelAndView edditcategory(@PathVariable("Cat_id")String id)
	{
		System.out.println(123);
		List<Category> categories=categoryDao.list();
		ModelAndView obj = new ModelAndView("catagoryform");
		category=categoryDao.getCategory(id);
		obj.addObject("categories",categories);
		obj.addObject("cat",category);
		return obj;
		
	}
	@RequestMapping("/deletecategory/{Cat_id}")
	public ModelAndView deletecategory(@PathVariable("Cat_id")String Cat_id)
	{
		
		ModelAndView obj = new ModelAndView("redirect:/category");
		if(categoryDao.delete(Cat_id))
		{
			obj.addObject("msg","category is deleted successfuly");		
		}
		else
		{
			obj.addObject("msg","category is not  deleted");
		}
		
		return obj;
		
	}
	@RequestMapping("/dispcategory/{Cat_id}")
	public ModelAndView dispcategory(@PathVariable("Cat_id")String id)
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Catprod");
		List<Product> c= productDao.getproductC(id);
	     obj.addObject("pro",c);
	     obj.addObject("cat", new Category());
	     obj.addObject("categories",categories);
	     return obj;
		
	}
	@RequestMapping("/dispproid")
	public String dispprod(@RequestParam("search")String s, Model model )
	{	if(s==null||s.isEmpty())
	{
		System.out.println("No products to display");
		return "redirect:/";
	}
	else
	{
		List<Category> categories=categoryDao.list(); 
		List<Product> products=productDao.getproductPro(s);
		model.addAttribute("cat", new Category());
		model.addAttribute("categories",categories);
		 model.addAttribute("products", products);
	     return "allproducts" ;
	}
	}
	@RequestMapping("/disrate/")
	public ModelAndView disprate()
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Rateprod");
		List<Product> c= productDao.getproductPrice();
	     obj.addObject("pro",c);
	     obj.addObject("cat", new Category());
	     obj.addObject("categories",categories);
		return obj;
		
	}
	@RequestMapping("/disrate1/")
	public ModelAndView disprate1()
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Rateprod");
		List<Product> c= productDao.getproductPrice2();
	     obj.addObject("pro",c);
	     obj.addObject("cat", new Category());
	     obj.addObject("categories",categories);
		return obj;
		
	}@RequestMapping("/disrate2/")
	public ModelAndView disprate2()
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj= new ModelAndView("Rateprod");
		List<Product> c= productDao.getproductPrice3();
		  obj.addObject("cat", new Category());
		     obj.addObject("categories",categories); 
		obj.addObject("pro",c);
		return obj;
		
	}
//	@RequestMapping(value= "/disrate/")
//	 public String viewproducts(Model model)
//	 {
//		List<Product> c= productDao.getproductPrice();
//		 model.addAttribute("pro", c);
//		 return "disrate";
//	 }

}
