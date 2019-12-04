package net.kzn.shoppingbackend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User_Details;
import net.kzn.shoppingbackend.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	UserDAO userDAO;
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel register,User_Details user){
		register.setUser(user);
	}
	
	public void addBilling(RegisterModel register,Address address){
		register.setBilling(address);
	}
	
	public String registerDetails(RegisterModel model){
		//user details
		User_Details user = model.getUser();
		if(user.getRole().equalsIgnoreCase("user")){
			Cart cart = new Cart();
			user.setCart(cart);
			cart.setUserDetails(user);
		}
		int userId = userDAO.addUserDetails(user);
		//Address details
		user.setId(userId);
		Address address = model.getBilling();
		address.setBilling(true);
		address.setUser_Details(user);
		return "success";
	}

}
