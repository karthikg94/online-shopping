package net.kzn.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="cart_line")
public class CartLine implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Column(name="cart_id")
	private int cartId;
	@Column(name="total")
	private float total;
	@Column(name="buying_price")
	private float buyingPrice;
	@Column(name="is_avaliable")
	private boolean avaliable;
	@OneToOne
	private Product product;
	@Column(name="Product_Count")
	private int productCount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	
	public boolean isAvaliable() {
		return avaliable;
	}
	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	@Override
	public String toString() {
		return "CartLine [id=" + id + ", cartId=" + cartId + ", total=" + total + ", buyingPrice=" + buyingPrice
				+ ", avaliable=" + avaliable + ", product=" + product + ", productCount=" + productCount + "]";
	}
	
	
	
	
}
