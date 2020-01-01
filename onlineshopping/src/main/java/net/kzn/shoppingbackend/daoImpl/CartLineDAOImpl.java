package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CartLineDAO;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.CartLine;

@Repository("CartLineDAOImpl")
@Transactional
public class CartLineDAOImpl implements CartLineDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public CartLine getCartLine(int id) {
		return sessionFactory.getCurrentSession().find(CartLine.class, new Integer(id));
	}

	@Override
	public void addCartLine(CartLine cartLine) {
		sessionFactory.getCurrentSession().persist(cartLine);
	}

	@Override
	public CartLine updateCartLine(CartLine cartLine) {
		return (CartLine)sessionFactory.getCurrentSession().merge(cartLine);
	}

	@Override
	public boolean deleteCartLine(CartLine cartLine) {
		try{
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CartLine> list(int cartId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CartLine.class);
		criteria.add(Restrictions.eq("cartId", cartId));
		return criteria.list();
	}

	@Override
	public List<CartLine> listAvaliable(int cartId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CartLine.class);
		criteria.add(Restrictions.eq("cartId", cartId));
		criteria.add(Restrictions.eq("isAvaliable", true));
		return criteria.list();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "from CartLine where cartId = :cartId and product.id = :productId";
		return sessionFactory.getCurrentSession().createQuery(query,CartLine.class)
												 .setParameter("cartId", cartId)
												 .setParameter("productId", productId)
												 .getSingleResult();
	}
	
	@Override
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().merge(cart);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
