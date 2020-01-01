package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User_Details;

@Repository("UserDAOImpl")
@Transactional
public class UserDAOImpl implements UserDAO{

	Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	@Autowired
	SessionFactory sf;
	
	@Override
	public Integer addUserDetails(User_Details user) {
		try{
			Session session = sf.getCurrentSession();
			return (Integer)session.save(user);
			
		}catch (Exception e) {
			logger.error("Exception in addUserDetails() "+e);
			return null;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try{
			Session session = sf.getCurrentSession();
			session.persist(address);
			return true;
		}catch (Exception e) {
			logger.error("Exception in addAddress() "+e);
			return false;
		}
		
	}

	@Override
	public User_Details getUserByEmail(String email) {
		String query = "from User_Details where email = :email";
		try{
			return sf.getCurrentSession().createQuery(query,User_Details.class).setParameter("email", email).getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addAdress(Address address) {
		try{
			sf.getCurrentSession().persist(address);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Address getBillingAddress(int userId) {
		try{
			return sf.getCurrentSession().createNamedQuery("Billing_userId", Address.class)
					.setParameter("user_Details", new Integer(userId))
					.setParameter("billing", true).getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> getShippingAddress(int userId) {
		try{
			return sf.getCurrentSession().createNamedQuery("Shipping_userId", Address.class)
					.setParameter("user_Details", new Integer(userId))
					.setParameter("billing", true).getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Address getBillingAddress(User_Details user) {
		try{
			String query = "from Address where user_Details=:user_Details and billing=:billing";
			return sf.getCurrentSession().createQuery(query, Address.class).setParameter("user_Details", user)
			.setParameter("billing", true).getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> getShippingAddress(User_Details user) {
		String query = "from Address where user_Details=:user_Details and shipping=:billing";
		return sf.getCurrentSession().createQuery(query, Address.class).setParameter("user_Details", user)
		.setParameter("billing", true).getResultList();
	}
	
	

}
