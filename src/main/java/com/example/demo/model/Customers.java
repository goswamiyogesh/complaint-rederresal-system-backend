package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="tbl_customer")
public class Customers {
	@Id
	private String customerEmail;
	
	private String customerPassword;
	private String customerName;
	private String customerMobile;
	private String customerAddress;
	private String customerPincode;
}