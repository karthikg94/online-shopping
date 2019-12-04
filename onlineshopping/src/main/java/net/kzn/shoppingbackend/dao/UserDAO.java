package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User_Details;

public interface UserDAO {

	public Integer addUserDetails(User_Details user);
	public boolean addAddress(Address address);
	public boolean updateCart(Cart cart);
	public User_Details getUserByEmail(String email);
	public boolean addAdress(Address address);
	public Address getBillingAddress(int userId);
	public List<Address> getShippingAddress(int userId);
	public Address getBillingAddress(User_Details user);
	public List<Address> getShippingAddress(User_Details user);
}
