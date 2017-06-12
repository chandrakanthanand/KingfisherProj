package com.niit.kingfisherbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.kingfisherbackend.Dao.CategoryDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.Dao.SellerDao;
import com.niit.kingfisherbackend.model.Category;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.Seller;



public class ProductTest {

	public static void main(String a[]) {

		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		
		context.refresh();
		
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		Product p = (Product) context.getBean("product");

		Category category=(Category)context.getBean("category");
		CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
		
		
		Seller seller=(Seller)context.getBean("seller");
		SellerDao sellerDao=(SellerDao)context.getBean("sellerDao");
		
		category=categoryDao.getCategory("CAT4B829E");
		p.setCategory(category);
		
		seller=sellerDao.getSeller("SEL789F82");
		p.setSeller(seller);
		
		
		p.setP_Name("vodka");
		p.setQue(45);
		p.setPrice(100.00f);
		p.setCategory(category);
		// save and update
		if (productDao.saveProduct(p) == true) {
			System.out.println("product Saved");

		} else {
			System.out.println("product is not saved");
		}
//		// Delete
//		 if(productDao.delete("B12")==true)
//		 {
//		 System.out.println("product has been deleted");
//		 }
//		 else
//		 {
//		 System.out.println("product is not delete");
//		 }
//
//		 p=(Product)productDao.getproduct("B126");
//			if(p==null)
//			{
//				System.out.println("no user is found");
//			}
//			else
//			{
//				System.out.println(p.getP_id());
//			}
	}

}

