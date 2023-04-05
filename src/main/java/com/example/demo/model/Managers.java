package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="tbl_manager")
public class Managers {
@Id
private String managerEmail;
private String managerPassword;
private String managerName;
private String managerPincode;
}
