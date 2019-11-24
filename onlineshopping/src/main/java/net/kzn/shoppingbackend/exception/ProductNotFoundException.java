package net.kzn.shoppingbackend.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public ProductNotFoundException() {
		this("Product Not Found");
	}

	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis()  +": "+message;
	}
	
	
}
