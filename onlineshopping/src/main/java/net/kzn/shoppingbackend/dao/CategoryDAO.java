package net.kzn.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dto.Category;

public interface CategoryDAO {
	public List<Category> list();
	public Category getCategoryById(Integer id);
	public boolean addCategory(Category category);
	public Category updateCategory(Category category);
	public void deleteCategory(Category category);
}
