package com.niit.kingfisherbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.kingfisherbackend.Dao.BillingDao;
import com.niit.kingfisherbackend.Dao.CardDao;
import com.niit.kingfisherbackend.Dao.CartDao;
import com.niit.kingfisherbackend.Dao.OrderDao;
import com.niit.kingfisherbackend.Dao.PayDao;
import com.niit.kingfisherbackend.Dao.ShippingAddressDao;
import com.niit.kingfisherbackend.Dao.UserDao;
import com.niit.kingfisherbackend.model.Billing;
import com.niit.kingfisherbackend.model.Card;
import com.niit.kingfisherbackend.model.Cart;
import com.niit.kingfisherbackend.model.Order;
import com.niit.kingfisherbackend.model.Pay;
import com.niit.kingfisherbackend.model.ShippingAddress;
import com.niit.kingfisherbackend.model.User;



public class OrderTest {
	public static void main(String a[]) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		BillingDao billingDao = (BillingDao) context.getBean("billingDao");
		Billing bill = (Billing) context.getBean("billing");
		
		ShippingAddressDao shippingAddressDao = (ShippingAddressDao) context.getBean("shippingAddressDao");
		ShippingAddress  shippingAddress=(ShippingAddress)context.getBean("shippingAddress");
		
		PayDao payDao = (PayDao) context.getBean("payDao");
		Pay  pay=(Pay)context.getBean("pay");
		
		UserDao userDao = (UserDao) context.getBean("userDao");
		User  user=(User)context.getBean("user");
		
		OrderDao orderDao = (OrderDao) context.getBean("orderDao");
		Order  order=(Order)context.getBean("order");
		
		CartDao cartDao = (CartDao) context.getBean("cartDao");
		Cart  cart=(Cart)context.getBean("cart");
		
		CardDao cardDao = (CardDao) context.getBean("cardDao");
		Card card=(Card)context.getBean("card");
		
		
		bill=billingDao.getbilling("BILL147600");
		order.setBilling(bill);
		
		pay=payDao.get("PAY8DA7B7");
		order.setPay(pay);
		
		shippingAddress=shippingAddressDao.get("Shippin37E42D");
		order.setShippingAddress(shippingAddress);
		
		user=userDao.getUser("USERA01638");
		order.setUser(user);
		
		order.setOrder_Id("9BN382");
		order.setGrand_total(150.00);
		
		if (orderDao.Saveorupdate(order)== true) {
			System.out.println("order Saved");

		} else {
			System.out.println("order is not saved");
		}
		
		
		
	}	
}
