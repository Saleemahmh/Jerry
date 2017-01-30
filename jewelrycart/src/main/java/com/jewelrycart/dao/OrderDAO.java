package com.jewelrycart.dao;

import com.jewelrycart.model.UserOrder;

public interface OrderDAO {
	void addOrder(UserOrder userOrder);
    double getOrderGrandTotal(int cartId);
}

