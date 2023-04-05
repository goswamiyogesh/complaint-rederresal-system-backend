package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Complaints;
import com.example.demo.repository.ComplaintRepository;

@Service
public class ComplaintService {
	@Autowired
	ComplaintRepository complaintRepository;
	

	public void saveComplaint(Complaints complaint) {
		complaintRepository.save(complaint);
		
	}
	
	public Complaints findComplaintById(int ticketId) {
		Complaints complaint = complaintRepository.findById(ticketId).orElse(null);
		return complaint;
	}


	public void deleteComplaint(Complaints complaint) {
		complaintRepository.delete(complaint);
		
	}

	public List<Complaints> findComplaintByEmail(String customerEmail) {
		return complaintRepository.findComplaintByCustomerEmail(customerEmail);
	}

}
