package net.kzn.onlineshopping.category;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User_Details;

public class UserDetailsTest {

	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static UserDAO userDAO;
	private User_Details user;
	private Address address;
	private Cart cart;
	
	@BeforeClass
	public static void init(){
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.kzn");
		annotationConfigApplicationContext.refresh();
		userDAO = annotationConfigApplicationContext.getBean("UserDAOImpl",UserDAO.class);
	}
	
	@Test
	public void addUserDetails(){
		System.out.println("this is the start of the test case ##############");
		user = new User_Details();
		user.setContactNumber("9676941179");
		user.setEmail("karthikg94@gmail.com");
		user.setEnablee(true);
		user.setFirstName("Karthik");
		user.setLastName("Gouribhatla");
		user.setPassword("karthik");
		user.setRole("User");
//		user.setId(1);
		
//		Address address1 = userDAO.getBillingAddress(1);
//		List<Address> addressList = userDAO.getShippingAddress(1);
//		System.out.println("############ "+address1.getCity());
//		System.out.println("############ "+addressList.size());
//		Address address = userDAO.getBillingAddress(user);
		
//		System.out.println("this is the billing addresss "+address);
//		System.out.println("this is the billing addresss "+address.getCity()+ " "+address.getUser_Details());
//		try{
//			System.out.println(" this is the user details "+address.getUser_Details());
//			System.out.println(" this is the user details #####"+address.getUser_Details().getCart());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("this is the assert ");
		
		cart = new Cart();
		cart.setCartLine(1);
		cart.setGrandTotal(1000);
//		cart.setId(1);
		cart.setUserDetails(user);
		user.setCart(cart);
//		
		int result = userDAO.addUserDetails(user);
		assertEquals(true, result);
//		
//		User_Details details = userDAO.getUserByEmail("karthikg94@gmail.com");
//		cart = details.getCart();
//		cart.setCartLine(2);
//		result = userDAO.updateCart(cart);
//		assertEquals(true, result);
		
		
		
//		address = new Address();
//		address.setAddressLine1("address3");
//		address.setAddressLine2("address4");
//		address.setCity("Bang");
//		address.setCountry("India");
////		address.setId(2);
//		address.setPostalCode("600062");
////		address.setBilling(true);
//		address.setShipping(true);
//		address.setState("KS");
//		address.setUser_Details(user);
//		boolean result1 = userDAO.addAddress(address);
//		assertEquals(true,result1);
//		
		
//		cart.setUserId(user.getId());
//		boolean result2 = userDAO.addCart(cart);
//		assertEquals(true,result2);
		
		
		
	}
	
}
