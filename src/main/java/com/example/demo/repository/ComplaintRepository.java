package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Complaints;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaints, Integer>{
	List<Complaints> findComplaintByCustomerEmail(String customerEmail);

	List<Complaints> findComplaintByPincode(String managerPincode); 
}
