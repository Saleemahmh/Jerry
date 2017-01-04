package com.niit.bjeweledbackend.dao;

import com.niit.bjeweledbackend.model.Register;

public interface RegisterDAO {
	public void addUser(Register reg);
	
	public Register getInfo(String lc);
}
