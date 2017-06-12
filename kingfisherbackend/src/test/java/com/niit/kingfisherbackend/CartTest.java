package com.niit.kingfisherbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.kingfisherbackend.Dao.CartDao;
import com.niit.kingfisherbackend.Dao.CartItemDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.Dao.UserDao;
import com.niit.kingfisherbackend.model.Cart;
import com.niit.kingfisherbackend.model.CartItem;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.User;


public class CartTest 
{
	public static void main(String a[]) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CartDao cartDao = (CartDao) context.getBean("cartDao");
		Cart ct = (Cart) context.getBean("cart");
		
		CartItemDao cartItemDao = (CartItemDao) context.getBean("cartItemDao");
		CartItem  CartItem=(CartItem)context.getBean("cartItem");
		
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		Product  Product=(Product)context.getBean("product");
		
		UserDao userDao=(UserDao)context.getBean("userDao");
		User u=(User)context.getBean("user");
		
		User user = userDao.getUser("USERAC728C");
	    
		if (user==null)
		{
			System.out.println("sorry User is not login");
		}
		else
		{	
		ct=cartDao.getcart(u.getCart().getCart_id()); 
        Product  product=productDao.getproduct("PRO1C7E56");
//        CartItem.setP_id(CartItem.getP_id());
          CartItem.setPrice(product.getPrice());
          CartItem.setCart(ct);
        
          cartItemDao.saveCartItem(CartItem);
          ct.setGroand_total(ct.getGroand_total()+product.getPrice());
          ct.setTotal_item(ct.getTotal_item());
          cartDao.saveCart(ct);
          
          
		}
}
}