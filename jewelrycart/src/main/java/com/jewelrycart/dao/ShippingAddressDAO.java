package com.jewelrycart.dao;

import com.jewelrycart.model.ShippingAddress;

public interface ShippingAddressDAO {
	void saveOrUpdate(ShippingAddress shippingAddress);
	
	void deleteShippingAddress(String shippingAddressId);

	ShippingAddress getShippingAddress(String shippingAddressId);



}
