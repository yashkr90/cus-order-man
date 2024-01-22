package com.ibm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Orders")
public class Order {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private String orderId;
	
	@Column(name = "OrderType")
	private String orderType;
	
	@Column(name = "OrderPrice")
	private Double orderPrice;
	
	@Column(name = "IsConfirmed")
	private Boolean isConfirmed;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CustomerId")
	private Customer customer;
	
}
