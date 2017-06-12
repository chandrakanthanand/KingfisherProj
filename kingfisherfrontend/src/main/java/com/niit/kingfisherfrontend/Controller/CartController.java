package com.niit.kingfisherfrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.kingfisherbackend.Dao.CartDao;
import com.niit.kingfisherbackend.Dao.CartItemDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.Dao.UserDao;
import com.niit.kingfisherbackend.model.Cart;
import com.niit.kingfisherbackend.model.CartItem;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.User;


@Controller
public class CartController {

	@Autowired 
	User user;
	@Autowired 
	UserDao userDao;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItem cartItem;
	@Autowired
	CartItemDao cartItemDao;
	
	@Autowired
	Product product;
	@Autowired 
	ProductDao productDao;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/addtocart/{id}")
	public ModelAndView cart(@PathVariable("id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
			if (user == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.getproduct(id);
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setPrice(product.getPrice());
				cartItemDao.saveCartItem(cartItem);
				cart.setGroand_total(cart.getGroand_total() + product.getPrice());
				cart.setTotal_item(cart.getTotal_item() + 1);
				cartDao.saveCart(cart);
				session.setAttribute("items", cart.getTotal_item());
				session.setAttribute("gd", cart.getGroand_total());
				return new ModelAndView("redirect:/allproducts");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	@RequestMapping("/addtocartR/{id}")
	public ModelAndView cartr(@PathVariable("id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
			if (user == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.getproduct(id);
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setPrice(product.getPrice());
				cartItemDao.saveCartItem(cartItem);
				cart.setGroand_total(cart.getGroand_total() + product.getPrice());
				cart.setTotal_item(cart.getTotal_item() + 1);
				cartDao.saveCart(cart);
				session.setAttribute("items", cart.getTotal_item());
				session.setAttribute("gd", cart.getGroand_total());
				return new ModelAndView("redirect:/viewcart");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	@RequestMapping("/addtocartC/{id}")
	public ModelAndView cartc(@PathVariable("id") String id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
			if (user == null) {
				return new ModelAndView("redirect:/");
			} else {

				cart = u.getCart();
				product = productDao.getproduct(id);
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setPrice(product.getPrice());
				cartItemDao.saveCartItem(cartItem);
				cart.setGroand_total(cart.getGroand_total() + product.getPrice());
				cart.setTotal_item(cart.getTotal_item() + 1);
				cartDao.saveCart(cart);
				session.setAttribute("items", cart.getTotal_item());
				session.setAttribute("gd", cart.getGroand_total());
				return new ModelAndView("redirect:/viewcart");
			}
		} else {
			return new ModelAndView("redirect:/");
		}

	}


	@RequestMapping(value = "/viewcart")
	public String viewcart(Model model, HttpSession session) {
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
		        Cart c=u.getCart();
				List<CartItem> cartItem = cartItemDao.getlist(u.getCart().getCart_id());
				if(cartItem==null ||cartItem.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "viewcart";		
				}
				model.addAttribute("cartItem", cartItem);
				model.addAttribute("gtotal",c.getGroand_total());
				session.setAttribute("items",c.getTotal_item());
			    session.setAttribute("cartId", c.getCart_id());
				return "viewcart";		
			
		}
		else
		{
			return "redirect:/";
		}
		
	}
	@RequestMapping(value="/Remove/{id}")
	public String RemoveFromCart(@PathVariable("id") String id)
	{
		cartItem=cartItemDao.getcartItem(id);
		Cart c=cartItem.getCart();
		c.setGroand_total(c.getGroand_total()-cartItem.getPrice());
		c.setTotal_item(c.getTotal_item()-1);
		cartDao.saveCart(c);
		cartItemDao.delete(cartItem.getCi_id());
		return "redirect:/viewcart";
	}
	
	@RequestMapping(value="/Removeall")
	public String RemoveallFromCart(Model model,HttpSession session)
	{
		Cart c=cartDao.getcart((String)session.getAttribute("cartId"));
		List<CartItem> cartItems=cartItemDao.getlist((String)session.getAttribute("cartId"));
		for(CartItem g:cartItems)
		{
		  cartItemDao.delete(g.getCi_id());
		}
		c.setGroand_total(0.0);
		c.setTotal_item(0);
		cartDao.saveCart(c);
		session.setAttribute("items",c.getTotal_item());
		return "redirect:/viewcart";
	}

}
