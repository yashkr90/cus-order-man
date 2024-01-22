package com.ibm.repository;

import com.ibm.model.Order;
import java.util.*;

public interface OrderRepo {
	

	Order createOrder(Order order);
	List<Order> getAllOrders();
}

