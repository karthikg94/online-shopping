package net.kzn.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User_Details implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message="Please enter First Name")
	private String firstName;
	@NotBlank(message="Please enter Last Name")
	private String lastName;
	@NotBlank(message="Please enter Email Address")
	@Email
	private String email;
	@NotBlank(message="Please enter Password")
	private String password;
	@NotBlank(message="Please enter Confirm Password")
	@Transient
	private String confirmPassword;
	@NotBlank(message="Please enter Contact Number")
	private String contactNumber;
	@NotBlank(message="Please Choose Role")
	private String role;
	private boolean enablee;
	@OneToOne(mappedBy="userDetails",cascade=CascadeType.ALL)
	private Cart cart;
	
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnablee() {
		return enablee;
	}
	public void setEnablee(boolean enablee) {
		this.enablee = enablee;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "User_Details [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contactNumber=" + contactNumber + ", role=" + role + ", enablee="
				+ enablee + ", cart=" + cart + "]";
	}
	
}
