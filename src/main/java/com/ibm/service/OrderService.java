package com.ibm.service;

import java.util.List;

import com.ibm.model.Order;

public interface OrderService {

	Order createOrder(Order order);
	List<Order> getAllOrders();
	Order updateOrder(String orderid);
	void deleteOrder(String orderId);
}
