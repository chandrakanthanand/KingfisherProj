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



public class CartItemTest {
	
	public static void main(String a[]) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		CartItemDao cartItemDao = (CartItemDao) context.getBean("cartItemDao");
		CartItem citem = (CartItem) context.getBean("cartItem");
		
		User user=(User)context.getBean("user");
		UserDao userDao=(UserDao)context.getBean("userDao");
		 
		Product p=(Product)context.getBean("product");  
		ProductDao productDao=(ProductDao)context.getBean("productDao"); 
		
		Cart cart=(Cart)context.getBean("cart"); 
		CartDao cartDao=(CartDao)context.getBean("cartDao");
		
		
		
		User u=userDao.getUser("USER22EB7F");
		
		Product pro=(Product)productDao.getproduct("PRO3F5C03");
		citem.setCart(user.getCart());
		citem.setProduct(citem.getProduct());
		citem.setPrice(p.getPrice());
		
		
		if(cartItemDao.saveCartItem(citem)==true)
		{
			System.out.println("Cart is added");
		}
		if(cartItemDao.delete("CIEME47AFD")==true)
			{
				System.out.println("Cart is deleted");
			}
			else
			{
				System.out.println("Cart is not deleted");
			}
		cart=u.getCart();
		cart.setGroand_total(cart.getGroand_total()+p.getPrice());
		cart.setTotal_item(cart.getTotal_item()+1);
		cartDao.saveCart(cart);
			
}
}