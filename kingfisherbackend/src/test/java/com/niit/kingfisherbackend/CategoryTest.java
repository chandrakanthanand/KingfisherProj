package com.niit.kingfisherbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.kingfisherbackend.Dao.CategoryDao;

import com.niit.kingfisherbackend.model.Category;


public class CategoryTest {

	public static void main(String a[]) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		Category cat = (Category) context.getBean("category");
		
		cat.setCat_name("bgfdg");
		cat.setCat_des("kidfg");
		
		// save and update
		if (categoryDao.Savecategory(cat)) {
			System.out.println("category Saved");

		} else {
			System.out.println("category is not saved");
		}
		// Delete
//		 if(categoryDao.delete("cat789")==true)
//		 {
//		 System.out.println("category has been deleted");
//		 }
//		 else
//		 {
//		 System.out.println("category is not delete");
//		 }
		
		
//		 cat=(Category)categoryDao.getCategory("cat789");
//		 if(cat==null)
//		 {
//		 System.out.println("no user is found");
//		 }
//		 else
//		 {
//		 System.out.println(cat.getCat_id());
//		 }

	}

}
