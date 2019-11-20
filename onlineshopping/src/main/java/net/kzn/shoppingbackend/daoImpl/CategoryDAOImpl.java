package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try{
			Session session = sessionFactory.getCurrentSession();
			System.out.println("addcategory got session");
			session.persist(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Category> list() {
		//using criteria
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		return criteria.list();
		//using HQL
//		return sessionFactory.getCurrentSession().createQuery("From Category").list();
	}

	@Override
	public Category getCategoryById(Integer id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public Category updateCategory(Category category) {
		Category updatedCategory = (Category)sessionFactory.getCurrentSession().merge(category);
		return updatedCategory;
	}

	@Override
	public void deleteCategory(Category category) {
		sessionFactory.getCurrentSession().delete(category);
	}

	
}
