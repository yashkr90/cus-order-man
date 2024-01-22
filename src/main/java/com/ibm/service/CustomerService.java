package com.ibm.service;

import com.ibm.model.Customer;
import java.util.*;

public interface CustomerService {

	Customer createCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer updateCustomer(String customerId);
}
