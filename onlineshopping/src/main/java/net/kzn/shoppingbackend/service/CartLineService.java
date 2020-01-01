package net.kzn.shoppingbackend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.kzn.shoppingbackend.dao.CartLineDAO;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.CartLine;
import net.kzn.shoppingbackend.model.UserModel;

@Service
public class CartLineService {

	@Autowired
	CartLineDAO cartLineDAO;
	
	@Autowired
	HttpSession session;
	
	public Cart getCart(){
		UserModel user =  (UserModel)session.getAttribute("userModel");
		return user.getCart();
	}
	
	public List<CartLine> getCartLine(){
		return cartLineDAO.list(this.getCart().getId());
	}
}
