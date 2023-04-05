package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="tbl_engineer")
public class Engineers {
	@Id
	private String engineerEmail;
	
	private String engineerPassword;
	private String engineerName;

}
