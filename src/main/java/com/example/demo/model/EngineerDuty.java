package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Table(name="tbl_engineerDuty")
@Entity
@Data
public class EngineerDuty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int engineerDutyId;
	
	private String engineerEmail;
	private int ticketId;
	private String customerEmail;
	
	
}
