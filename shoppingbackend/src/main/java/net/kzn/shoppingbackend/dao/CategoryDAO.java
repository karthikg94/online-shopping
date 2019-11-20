package net.kzn.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dto.CategoryDTO;

public interface CategoryDAO {
	public List<CategoryDTO> list();
}
