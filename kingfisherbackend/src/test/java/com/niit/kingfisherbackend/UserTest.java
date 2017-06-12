//package com.niit.kingfisherbackend;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.kingfisherbackend.Dao.CartDao;
//import com.niit.kingfisherbackend.Dao.UserDao;
//import com.niit.kingfisherbackend.model.Cart;
//import com.niit.kingfisherbackend.model.User;
//
//public class UserTest 
//{
//	
//	public static void main(String[] args){
//		@SuppressWarnings("resource")
//		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
//		context.scan("com.niit.*");
//		context.refresh();
//		UserDao userDao=(UserDao)context.getBean("userDao");
//		User u=(User)context.getBean("user");
//		CartDao cartDao = (CartDao) context.getBean("cartDao");
//		Cart cart= (Cart) context.getBean("cart");
//		
//		u.setU_name("Chandrakant");
//		u.setU_gender("male");
//		u.setU_add("banglore");
//		u.setU_phno("1232");
//		u.setU_email("ck@gmail.com");
//		u.setU_psw("123");
//		u.setCart(cart);
//			
//        
//        
//		// save and update
//		
//				if (userDao.SaveOrUpdate(u)==true)
//				{
//					System.out.println("User Saved");
//				
//				}
//				else
//				{
//					System.out.println("User is not saved");
//				}
//				
//				// Delete
//				
////				if(userDao.delete("u78")==true)
////				{
////					System.out.println("User has been deleted");
////				}
////				else
////				{
////					System.out.println("User is not delete");
////				}
//				
//				
////				u=(User)userDao.getUser("u78");
////				if(u==null)
////				{
////					System.out.println("no user is found");
////				}
////				else
////				{
////					System.out.println(u.getU_Id());
////				}
//
//		
////		 User U= userDao.isValidated("akasg@gmail.com","123");
////		  if(u==null)
////		  {
////			  System.out.println("id and pwd is not available");
////		  }
////		  else
////		  {
////			  System.out.println("id and pwd is available");
////		  }
////		  
//		
//		
//		
//		
//	}	
//
//}
