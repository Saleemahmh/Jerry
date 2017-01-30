package com.jewelrycart.dao;

import java.io.IOException;

import com.jewelrycart.model.Cart;

public interface CartDAO {
	 Cart getCartById (int cartId);
Cart validate(int cartId) throws IOException;
	   void update(Cart cart);
}
