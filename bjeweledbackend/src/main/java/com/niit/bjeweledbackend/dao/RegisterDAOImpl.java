package com.niit.bjeweledbackend.dao;


import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bjeweledbackend.model.Register;



@Transactional
@EnableTransactionManagement
@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO {
	private static final Logger log = LoggerFactory.getLogger(RegisterDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	public RegisterDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;

	}
	@Transactional
	public List<Register> list() {
		
		@SuppressWarnings("unchecked")
		List<Register> listRegister = (List<Register>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Register.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listRegister;
	}
@Transactional
public boolean save(Register register)
{
try {
	 Session session = sessionFactory.getCurrentSession();
	
	register.setRole("ROLE_USER");
	register.setEnabled(true);
        session.saveOrUpdate(register);

        session.flush();
	
	return true;

}
catch(Exception e)
{
	
	e.printStackTrace();
	return false;
}
}
@Transactional
	public boolean update(Register register)
	{
	try {
		log.debug("starting of update method");
		sessionFactory.getCurrentSession().update(register);
		log.debug("starting of update method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in update" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(Register register)
	{
	try {
		log.debug("starting of delete method");
		sessionFactory.getCurrentSession().delete(register);
		log.debug("starting of delete method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in delete" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
public Register get(String username)
{
	String hql = "from Register where username= "+" '" +username+ "'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Register> list = query.list();
	if(list == null || list.isEmpty())
	{
		return null;
	}
	else
	{
		return list.get(0);
	}
}

@Transactional
public boolean isValidUser(String username, String password) {
	System.out.println("dao impl");
	String hql ="from Register where username= '" + username + "' and " + " password ='" + password + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Register> list = (List<Register>) query.list();
	if(list != null && !list.isEmpty())
	{
	
		return true;
	}
	return false;

}

@Transactional
public Register getCustomerByUsername(String username) {

	String hql = "from Register where username=" + "'" + username + "'";
	
Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
List<Register> listOfCustomers = query.list();
	
if (listOfCustomers != null && !listOfCustomers.isEmpty()){

	return  listOfCustomers.get(0);

}
return null;
}
}