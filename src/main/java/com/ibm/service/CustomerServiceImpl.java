package com.ibm.service;

import java.util.List;

import com.ibm.model.Customer;
import com.ibm.repository.CustomerRepo;
import com.ibm.repository.CustomerRepoImpl;

public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepo customerRepo;
	
	{
		customerRepo= new CustomerRepoImpl();
	}
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.createCustomer(customer);
	}
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.getAllCustomers();
	}
	@Override
	public Customer updateCustomer(String customerId) {
		// TODO Auto-generated method stub
		return customerRepo.updateCustomer(customerId);
	}
	@Override
	public void deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		customerRepo.deleteCustomer(customerId);
		
	}

}
