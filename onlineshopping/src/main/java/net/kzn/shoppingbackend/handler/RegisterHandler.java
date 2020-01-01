package net.kzn.shoppingbackend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		int userId = userDAO.addUserDetails(user);
		//Address details
		user.setId(userId);
		Address address = model.getBilling();
		address.setBilling(true);
		address.setUser_Details(user);
		return "success";
	}
	
	public String validate(User_Details user,MessageContext error){
		String transitionState = "success";
		if(!user.getPassword().equals(user.getConfirmPassword())){
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password and Confirm Password Mismatch").build());
			transitionState = "failure";
		}
		User_Details result = userDAO.getUserByEmail(user.getEmail());
		if(result != null){
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email Already Exists").build());
			transitionState = "failure";
		}
		return transitionState;
	}

}
