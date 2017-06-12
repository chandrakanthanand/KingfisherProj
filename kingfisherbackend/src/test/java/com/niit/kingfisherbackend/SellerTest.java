package com.niit.kingfisherbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.kingfisherbackend.Dao.SellerDao;
import com.niit.kingfisherbackend.model.Seller;


public class SellerTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		SellerDao sellerDao = (SellerDao) context.getBean("sellerDao");
		Seller se = (Seller) context.getBean("seller");
		//se.setId("s1452");
		se.setName("chandra");
		se.setAdd("Bangalore");
		se.setPhone("789654123");
	
		// save and update
		if (sellerDao.saveSeller(se) == true) {
			System.out.println("product Saved");

		} else {
			System.out.println("product is not saved");
		}
		// Delete
//		 if(sellerDao.delete("s1452")==true)
//		 {
//		 System.out.println("seller has been deleted");
//		 }
		
//		 else
//		 {
//		 System.out.println("seller is not delete");
//		 }
		
		
//		 se=(Seller)sellerDao.getSeller("s1452");
//			if(se==null)
//			{
//				System.out.println("no user is found");
//			}
//			else
//			{
//				System.out.println(se.getId());
//			}

	}

}
