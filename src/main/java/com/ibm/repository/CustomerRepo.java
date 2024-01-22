package com.ibm.repository;

import com.ibm.model.Customer;
import java.util.*;

public interface CustomerRepo {

	Customer createCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer updateCustomer(String customerId);
	void deleteCustomer(String customerId);
}
