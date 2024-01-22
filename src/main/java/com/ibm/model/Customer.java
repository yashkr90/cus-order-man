package com.ibm.model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customer")

public class Customer {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CustomerId")
	private String customerId;
	@Column(name="CustomerName")
	private String customerName;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "OrderId")
//	private Order order;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	
	// add convenience methods for bi-directional relationship
	
	public void add(Order temporder)
	{
		if(orders==null)
		{
			orders=new ArrayList<Order>();
		}
		orders.add(temporder);
		temporder.setCustomer(this);
	}
}
