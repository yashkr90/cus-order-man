package com.ibm.service;

import java.util.List;

import com.ibm.model.Order;
import com.ibm.repository.OrderRepo;
import com.ibm.repository.OrderRepoImpl;

public class OrderServiceImpl implements OrderService {
	
	private static OrderRepo orderRepo;
	{
		orderRepo= new OrderRepoImpl();
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepo.createOrder(order);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.getAllOrders();
	}

}
