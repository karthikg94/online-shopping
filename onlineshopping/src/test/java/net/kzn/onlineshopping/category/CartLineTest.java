package net.kzn.onlineshopping.category;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CartLineDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.CartLine;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.User_Details;

public class CartLineTest {

	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static UserDAO userDAO;
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private Cart cart;
	
	@BeforeClass
	public static void init(){
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.kzn.shoppingbackend");
		annotationConfigApplicationContext.refresh();
		userDAO = annotationConfigApplicationContext.getBean("UserDAOImpl",UserDAO.class);
		cartLineDAO = annotationConfigApplicationContext.getBean("CartLineDAOImpl",CartLineDAO.class);
		productDAO = annotationConfigApplicationContext.getBean("productDAO",ProductDAO.class);
	}
	
	@Test
	public void getUserDetails(){
		
		User_Details userDetails = userDAO.getUserByEmail("karthikg940@gmail.com");
		//get the user cart
		cart = userDetails.getCart();
		//get the product details
		Product product = productDAO.getProductById(1);
		//create a new cartLine
		CartLine cartLine = new CartLine();
		cartLine.setAvaliable(true);
		cartLine.setBuyingPrice(product.getUnit_price().floatValue());
		cartLine.setId(1);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnit_price().floatValue());
		//add cartLine
		cartLineDAO.addCartLine(cartLine);
		//get CartLine
		cartLine = cartLineDAO.getCartLine(cartLine.getId());
		assertEquals(cartLine.getId(),1);
		
		//update the cart table
		
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLine(cart.getCartLine()+1);
		boolean result = cartLineDAO.updateCart(cart);
		assertEquals(true, result);
		
		
	}
}
