package net.kzn.onlineshopping.category;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	private static CategoryDAO categoryDAO;
	private  Category category;
	
	@BeforeClass
	public static void init(){
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.kzn.shoppingbackend");
		annotationConfigApplicationContext.refresh();
		categoryDAO = annotationConfigApplicationContext.getBean("categoryDAO",CategoryDAO.class);
	}
	
	@Test @Ignore
	public void addCategory(){
		category = new Category();
		category.setActive(true);
		category.setDesc("This is the mi TV");
		category.setImageURL("http://mi.com");
		category.setName("Television");
		boolean result = categoryDAO.addCategory(category);
		assertEquals(true,result);
	}
	
	@Test @Ignore
	public void getCategoryById(){
		Category category = categoryDAO.getCategoryById(1);
		assertEquals(1, category.getId());
	}
	
	@Test 
	public void getAllCategroies(){
		List<Category> categories = categoryDAO.list();
		assertEquals(4, categories.size());
	}
	
	@Test @Ignore
	public void updateCategory(){
		Category category = new Category();
		category.setId(4);
		category.setActive(false);
		category.setDesc("This is the mi TV");
		category.setImageURL("http://mi.com");
		category.setName("Television");
		category = categoryDAO.updateCategory(category);
		assertEquals(false, category.isActive());
	}
	
	@Test @Ignore
	public void deleteCategory(){
		Category category = new Category();
		category.setId(5);
		categoryDAO.deleteCategory(category);
		category = categoryDAO.getCategoryById(5);
		assertEquals(null, category);
	}
}
