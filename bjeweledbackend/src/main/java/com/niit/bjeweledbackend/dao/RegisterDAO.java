package com.niit.bjeweledbackend.dao;

import java.util.List;

import com.niit.bjeweledbackend.model.Register;



public interface RegisterDAO {
public boolean save(Register register);
	
	public boolean update(Register register);
		
		public boolean delete(Register register);
		
		
		public List<Register> list();
				
		public boolean isValidUser(String username, String password);

		public Register get(String username);
		 Register getCustomerByUsername (String username);

}
