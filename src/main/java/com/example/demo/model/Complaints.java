package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="tbl_complaints")
public class Complaints {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	
	private String customerEmail;
	private String pincode;
	private String complaint;
	private String status = "raised";

}
