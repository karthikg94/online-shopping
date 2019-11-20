package net.kzn.onlineshopping.category;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;

import java.util.List;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTest {

	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static ProductDAO productDAO;
	private  Product product;
	
	@BeforeClass
	public static void init(){
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.kzn.shoppingbackend");
		annotationConfigApplicationContext.refresh();
		productDAO = annotationConfigApplicationContext.getBean("ProductDAO",ProductDAO.class);
	}
	
	@Test @Ignore
	public void addProduct(){
		product = new Product();
		product.setBrand("SChand");
		product.setCategory_id(3);
		product.setDescription("This is the SChand books");
		product.setIs_active(true);
		product.setName("SChand M");
		product.setPurchases(1);
		product.setQuantity(1);
		product.setUnit_price(1000.0);
		product.setViews(100);
		product.setSupplier_id(3);
		boolean result = productDAO.addProduct(product);
		assertEquals(true,result);
	}
	
	@Test @Ignore
	public void getProductById(){
		Product product = productDAO.getProductById(1);
		assertEquals(new Integer(1), product.getId());
	}
	
	@Test @Ignore
	public void getProductsList(){
		List<Product> product = productDAO.getAllProducts();
		assertEquals("SONY", product.get(0).getBrand());
	}
	
	@Test @Ignore
	public void updateProduct(){
		product = new Product();
		product.setId(7);
		product.setBrand("SChand");
		product.setCategory_id(3);
		product.setDescription("This is the SChand books in store");
		product.setIs_active(true);
		product.setName("SChand M");
		product.setPurchases(1);
		product.setQuantity(1);
		product.setUnit_price(1000.0);
		product.setViews(100);
		product.setSupplier_id(3);
		Product p = productDAO.updateProduct(product);
		assertEquals(product.getDescription(), p.getDescription());
	}
	
	@Test @Ignore
	public void listActiveProducts(){
		List<Product> product = productDAO.listActiveProducts();
		assertEquals(6,product.size());
	}
	
	@Test @Ignore 
	public void listActiveProductsByCategoryId(){
		List<Product> product = productDAO.listActiveProductsByCategoryId(1);
		assertEquals(4,product.size());
	}
	
	@Test @Ignore
	public void getLatestActiveProducts(){
		List<Product> product = productDAO.getLatestActiveProducts(5);
		assertEquals(5,product.size());
	}
}
