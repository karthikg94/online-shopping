package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Product;

public interface ProductDAO {

	public boolean addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(Integer id);
	public Product updateProduct(Product product);
	public void deleteProduct(Product product);
	public List<Product> listActiveProducts();
	public List<Product> listActiveProductsByCategoryId(Integer id);
	public List<Product> getLatestActiveProducts(Integer count);
	
}
