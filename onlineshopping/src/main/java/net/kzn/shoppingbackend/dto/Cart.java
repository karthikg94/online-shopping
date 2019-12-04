package net.kzn.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private int cartLine;
	private double grandTotal;
	@OneToOne
	@JoinColumn(name="userDetails_id")
	private User_Details userDetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartLine() {
		return cartLine;
	}
	public void setCartLine(int cartLine) {
		this.cartLine = cartLine;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public User_Details getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User_Details userDetails) {
		this.userDetails = userDetails;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartLine=" + cartLine + ", grandTotal=" + grandTotal + ", userDetails="
				+ userDetails + "]";
	}
	
	
}
