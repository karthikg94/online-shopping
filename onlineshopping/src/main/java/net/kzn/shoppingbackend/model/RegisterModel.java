package net.kzn.shoppingbackend.model;

import java.io.Serializable;

import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.User_Details;

public class RegisterModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private User_Details user;
	private Address billing;
	
	public User_Details getUser() {
		return user;
	}
	public void setUser(User_Details user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	
	
	

	
}
