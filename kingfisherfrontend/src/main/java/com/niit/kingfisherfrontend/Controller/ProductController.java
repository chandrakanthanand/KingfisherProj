package com.niit.kingfisherfrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.niit.kingfisherbackend.Dao.CategoryDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.Dao.SellerDao;
import com.niit.kingfisherbackend.model.Category;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.Seller;
import com.niit.kingfisherfrontend.fileinput.FileInput;

@Controller
public class ProductController {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Seller seller;
	
	@Autowired
	SellerDao sellerDao;
	
	String path="C:\\Users\\15\\workspace\\kingfisherfrontend\\src\\main\\webapp\\resource\\images\\";
	
	@RequestMapping("/product")
	public ModelAndView productform()
	{
		List<Product> product=productDao.list(); 
		List<Category> category=categoryDao.list();
		List<Seller> seller=sellerDao.list();
		ModelAndView obj = new ModelAndView("productform");
		obj.addObject("product", new Product());
		obj.addObject("pro",product);
		obj.addObject("cat", category);
		obj.addObject("sel", seller);
		return obj;
	}

	@RequestMapping(value="/addproduct" ,method = RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute("product")Product pro) {
		System.out.println(3214);
		ModelAndView p = new ModelAndView("redirect:"+"/product");
		
		
		if(productDao.saveProduct(pro)==true)
		{
			 FileInput.upload(path, pro.getPimg(), pro.getP_id()+".jpg");
	    	 
			p.addObject("msg","Product is added");  		
		}
		else
		{
			p.	addObject("msg","Sorry");
		}
		return p;
	}
	
	@RequestMapping("/editproduct/{id}")
	public ModelAndView editproduct(@PathVariable("id")String id)
	{
		
		List<Product> product=productDao.list();
		ModelAndView obj = new ModelAndView("productform");
	    Product	prod=productDao.getproduct(id);
	    obj.addObject("product",prod);
	    obj.addObject("pro",product);
	    List<Category> category=categoryDao.list();
		List<Seller> seller=sellerDao.list();
		obj.addObject("cat", category);
		obj.addObject("sel", seller);
		
		return obj;
	}
	
	@RequestMapping("/deleteproduct/{id}")
	public ModelAndView deleteproduct(@PathVariable("id")String id)
	{
		
		System.out.println(123);
		ModelAndView obj = new ModelAndView("redirect:/product");
		if(productDao.delete(id))
		{
			obj.addObject("msg","product is deleted successfuly");		
		}
		else
		{
			obj.addObject("msg","product is not  deleted");
		}
		
		return obj;
		
	}
}
