package com.ibm.factory;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.model.Customer;
import com.ibm.model.Order;

public class MyFactory {

	
	private static SessionFactory sessionFactory;
	
	static
	{
		try {
			sessionFactory= new Configuration().configure().addAnnotatedClass(Order.class).addAnnotatedClass(Customer.class).buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static SessionFactory getSessionFactory() throws Exception
	{
		return sessionFactory;
	}
	
	
}
