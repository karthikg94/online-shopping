package net.kzn.shoppingbackend.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedNativeQueries({
			@NamedNativeQuery(name="Billing_userId", query="select * from Address where user_Details_id=:user_Details and billing=:billing",resultClass=Address.class),
			@NamedNativeQuery(name="Shipping_userId", query="select * from Address where user_Details_id=:user_Details and shipping=:billing",resultClass=Address.class)
		})
public class Address implements  Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message="Please enter Address Line 1")
	private String addressLine1;
	@NotBlank(message="Please enter Address Line 2")
	private String addressLine2;
	@NotBlank(message="Please enter City")
	private String city;
	@NotBlank(message="Please enter State")
	private String state;
	@NotBlank(message="Please enter Country")
	private String country;
	@NotBlank(message="Please enter Postal Code")
	private String postalCode;
	private boolean billing;
	private boolean shipping;
	@ManyToOne(fetch=FetchType.EAGER)
	private User_Details user_Details;
	
	
	public User_Details getUser_Details() {
		return user_Details;
	}
	public void setUser_Details(User_Details user_Details) {
		this.user_Details = user_Details;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + ", billing="
				+ billing + ", shipping=" + shipping + ", user_Details=" + user_Details + "]";
	}
	
	
	
}
