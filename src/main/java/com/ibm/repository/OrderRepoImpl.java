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
import com.ibm.model.Order;

public class OrderRepoImpl implements OrderRepo {
	
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
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
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			
			order.setOrderId(UUID.randomUUID().toString());
			
			 System.out.print("Enter Order type: ");
			  order.setOrderType(br.readLine());
			  
			  System.out.println("enter order price: ");
			  order.setOrderPrice(Double.parseDouble(br.readLine()));
			  
			  System.out.println("enter is confirmed");
			  order.setIsConfirmed(Boolean.parseBoolean(br.readLine()));
			  
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		Session session= sessionFactory.openSession();
//		
//		session.getTransaction().begin();
//		session.persist(order);
//		session.getTransaction().commit();
		return order;
		
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		
		TypedQuery<Order> query=session.createQuery("FROM Orders o",Order.class);
		
		return query.getResultList();
		
		
	}

	@Override
	public Order updateOrder(String orderid) {
		
		Session session= sessionFactory.openSession();
		
		Order temporder= null;
		try {
			session.beginTransaction();
			 int choice;
			 System.out.println("1. update order type");
			 System.out.println("2. update order price");
			 System.out.println("3. update order isconfirmed");
			 
			 choice= Integer.parseInt(br.readLine());
			 
			 switch(choice)
			 {
			 
			 case 1:
				// session.beginTransaction();
				 System.out.println("Enter new order type");
				 String type= br.readLine();
				 Order o1= session.get(Order.class, orderid);
				 
				 if(o1==null)
					 break;
				 o1.setOrderType(type);
				 session.update(o1);
				 temporder=o1;
				 //session.getTransaction().commit();
				 
				 break;
				 
			 case 2:
				 //session.beginTransaction();
				 System.out.println("Enter new order price");
				 Double pr= Double.parseDouble(br.readLine());
				 
				 Order o2=session.get(Order.class, orderid);
				 
				 if(o2==null)
				 break;
				 o2.setOrderPrice(pr);
				 session.update(o2);
				 temporder=o2;
				 //session.getTransaction().commit();
				 
				 break;
				 
			 case 3:
				 
				 System.out.println("Enter if order confirmed");
				 Boolean cnf = Boolean.parseBoolean(br.readLine());
				 
				 Order o3 = session.get(Order.class, orderid);
				 if(o3==null)
					 break;
				 o3.setIsConfirmed(cnf);
				 session.update(o3);
				 temporder=o3;
				 //session.getTransaction().commit();
				 
				 break;
			
			  default:
				  System.out.println("Wrong choice");
				  break;
				 }
			 session.getTransaction().commit();
			 
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return temporder;
		
	
	}

	@Override
	public void deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Order o= session.find(Order.class, orderId);
		System.out.println(o);
		session.delete(o);
		
		session.getTransaction().commit();
		
	}

}
