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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
//@Data
@Getter
@Setter

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
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "CustomerId")
	private Customer customer;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderType=" + orderType + ", orderPrice=" + orderPrice
				+ ", isConfirmed=" + isConfirmed  + "]";
	}
	
	
}
