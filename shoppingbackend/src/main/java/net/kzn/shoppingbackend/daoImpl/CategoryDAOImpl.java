package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.CategoryDTO;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	public static List<CategoryDTO> list = new ArrayList<CategoryDTO>();
	
	static{
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(1);
		categoryDTO.setDesc("Welocme to the Television world");
		categoryDTO.setActive(true);
		categoryDTO.setImageURL("http://sony.com");
		categoryDTO.setName("Televisions");
		list.add(categoryDTO);
		
		CategoryDTO categoryDTO1 = new CategoryDTO();
		categoryDTO1.setId(2);
		categoryDTO1.setDesc("Welocme to the Mobile world");
		categoryDTO1.setActive(true);
		categoryDTO1.setImageURL("http://samsung.com");
		categoryDTO1.setName("Mobiles");
		list.add(categoryDTO1);
		
		CategoryDTO categoryDTO2 = new CategoryDTO();
		categoryDTO2.setId(3);
		categoryDTO2.setDesc("Welocme to the FAN world");
		categoryDTO2.setActive(true);
		categoryDTO2.setImageURL("http://havells.com");
		categoryDTO2.setName("FANS");
		list.add(categoryDTO2);
	}
	
	
	@Override
	public List<CategoryDTO> list() {
		return list;
	}

	
}
