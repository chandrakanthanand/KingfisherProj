package com.niit.kingfisherbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.kingfisherbackend.Dao.AuthenticationDao;
import com.niit.kingfisherbackend.Dao.BillingDao;
import com.niit.kingfisherbackend.Dao.CardDao;
import com.niit.kingfisherbackend.Dao.CartDao;
import com.niit.kingfisherbackend.Dao.CartItemDao;
import com.niit.kingfisherbackend.Dao.CategoryDao;
import com.niit.kingfisherbackend.Dao.OrderDao;
import com.niit.kingfisherbackend.Dao.OrderItemsDao;
import com.niit.kingfisherbackend.Dao.PayDao;
import com.niit.kingfisherbackend.Dao.ProductDao;
import com.niit.kingfisherbackend.Dao.SellerDao;
import com.niit.kingfisherbackend.Dao.ShippingAddressDao;
import com.niit.kingfisherbackend.Dao.UserDao;
import com.niit.kingfisherbackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.BillingDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.CardDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.CartDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.CartItemDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.CategoryDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.OrderDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.PayDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.ProductDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.SellerDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.ShippingAddressDaoImpl;
import com.niit.kingfisherbackend.DaoImpl.UserDaoImpl;
import com.niit.kingfisherbackend.model.Authentication;
import com.niit.kingfisherbackend.model.Billing;
import com.niit.kingfisherbackend.model.Card;
import com.niit.kingfisherbackend.model.Cart;
import com.niit.kingfisherbackend.model.CartItem;
import com.niit.kingfisherbackend.model.Category;
import com.niit.kingfisherbackend.model.Order;
import com.niit.kingfisherbackend.model.OrderItems;
import com.niit.kingfisherbackend.model.Pay;
import com.niit.kingfisherbackend.model.Product;
import com.niit.kingfisherbackend.model.Seller;
import com.niit.kingfisherbackend.model.ShippingAddress;
import com.niit.kingfisherbackend.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/king1");
		dataSource.setUsername("sa");
		dataSource.setPassword("king");
		return dataSource;
}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Seller.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(ShippingAddress.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("sellerDao")
	public SellerDao getSellrDao(SessionFactory sessionFactory) {
		return new SellerDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);

	}

	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory) {
		return new CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cartItemDao")
	public CartItemDao getCartItemDao(SessionFactory sessionFactory) {
		return new CartItemDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
		return new AuthenticationDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("billingDao")
	public BillingDao getBillingDao(SessionFactory sessionFactory) {
		return new BillingDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("shippingAddressDao")
	public ShippingAddressDao getShippingAddressDao(SessionFactory sessionFactory) {
		return new ShippingAddressDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("orderDao")
	public OrderDao getOrderDao(SessionFactory sessionFactory) {
		return new OrderDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("orderItemsDao")
	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
		return new OrderItemsDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory) {
		return new CardDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory) {
		return new PayDaoImpl(sessionFactory);
	}
	
	

}