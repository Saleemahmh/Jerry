/*package com.niit.bjeweledbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.bjeweledbackend.config.AppContextConfig;
import com.niit.bjeweledbackend.dao.PersonDAO;
import com.niit.bjeweledbackend.model.Person;

*//**
 * Hello world!
 *
 *//*
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppContextConfig.class);
        
        PersonDAO personDAO=(PersonDAO)context.getBean("personDAO");
        
        Person person=new Person();
        person.setName("Som");
        person.setCountry("India");
        
        personDAO.addPerson(person);
    }
}
*/