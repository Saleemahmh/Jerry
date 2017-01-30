package com.jewelrycart.dao;

import com.jewelrycart.model.Cart;
import com.jewelrycart.model.CartItem;

public interface CartItemDAO {
	void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByItemId (int itemId);

}
