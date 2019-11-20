package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sf;

	@Override
	public boolean addProduct(Product product) {
		try{
			sf.getCurrentSession().persist(product);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		return sf.getCurrentSession().createCriteria(Product.class).list();
	}

	@Override
	public Product getProductById(Integer id) {
		return sf.getCurrentSession().find(Product.class, id);
	}

	@Override
	public Product updateProduct(Product product) {
		return (Product)sf.getCurrentSession().merge(product);
	}

	@Override
	public void deleteProduct(Product product) {
		sf.getCurrentSession().delete(product);
	}

	@Override
	public List<Product> listActiveProducts() {
		Criteria criteria = sf.getCurrentSession().createCriteria(Product.class);
		Criterion  ca = Restrictions.eq("is_active", true);
		criteria.add(ca);
		return criteria.list();
	}

	@Override
	public List<Product> listActiveProductsByCategoryId(Integer id) {
		Criteria criteria = sf.getCurrentSession().createCriteria(Product.class);
		Criterion  ca = Restrictions.eq("is_active", true);
		Criterion  ca1 = Restrictions.eq("category_id", id);
		criteria.add(ca);
		criteria.add(ca1);
		return criteria.list();
	}

	@Override
	public List<Product> getLatestActiveProducts(Integer count) {
		Criteria criteria = sf.getCurrentSession().createCriteria(Product.class);
		Criterion  ca = Restrictions.eq("is_active", true);
		criteria.add(ca);
		criteria.addOrder(Order.desc("id"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(count);
		return criteria.list();
	}

}
