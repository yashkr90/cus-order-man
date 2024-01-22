package com.ibm.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.factory.MyFactory;
import com.ibm.model.Customer;

public class CustomerRepoImpl implements CustomerRepo{

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	private SessionFactory sessionFactory;
	
	{
		try {
			sessionFactory=MyFactory.getSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
			
			customer.setCustomerId(UUID.randomUUID().toString());
			
			 System.out.print("Enter customer Name: ");
			  customer.setCustomerName(br.readLine());
			  
			
//			  System.out.println("enter customer order id: ");
//			  customer.s(bufferedReader.readLine());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
//		Session session= sessionFactory.openSession();
//		session.getTransaction().begin();
//		session.persist(customer);
//		session.getTransaction().commit();
		return customer;

	}


	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		TypedQuery<Customer> query= session.createQuery("FROM Customer c",Customer.class);
		return query.getResultList();
	}


	@Override
	public Customer updateCustomer(String customerId) {
		Customer tempcus=null;
		try {
			Session session= sessionFactory.openSession();
			int choice;
			System.out.println("1.Update name");
			choice= Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			
			case 1: 
				session.beginTransaction();
				System.out.println("1.Enter name");
				String name= br.readLine();
				Customer cus=session.get(Customer.class, customerId);
				if(cus==null)
				{
					System.out.println("Customer not found");
					return tempcus;
				}
				cus.setCustomerName(name);
				session.update(cus);
				session.getTransaction().commit();
				return tempcus=cus;
				//break;
				
			default:System.out.println("wrong choice");
			break;
				
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempcus;
	}


	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		
	}

}
