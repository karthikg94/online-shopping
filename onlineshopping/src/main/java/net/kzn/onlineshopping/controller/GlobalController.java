package net.kzn.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.User_Details;
import net.kzn.shoppingbackend.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	HttpSession session;

	@Autowired
	UserDAO userDAO;

	UserModel userModel;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String email = authentication.getName();
			User_Details user = userDAO.getUserByEmail(email);
			if (user != null) {
				userModel = new UserModel();
				if (user.getRole().equalsIgnoreCase("USER")) {
					userModel.setCart(user.getCart());
				}
				userModel.setEmail(user.getEmail());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				userModel.setId(user.getId());
				userModel.setRole(user.getRole());
				session.setAttribute("userModel", userModel);
			}
		}
		return (UserModel) session.getAttribute("userModel");
	}
}
