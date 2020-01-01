package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	public CartLine getCartLine(int id);
	public void addCartLine(CartLine cartLine);
	public CartLine updateCartLine(CartLine cartLine);
	public boolean deleteCartLine(CartLine cartLine);
	public List<CartLine> list(int cartId);
	public List<CartLine> listAvaliable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);
	public boolean updateCart(Cart cart);
}
