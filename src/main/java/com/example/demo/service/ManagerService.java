package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Complaints;
import com.example.demo.model.Managers;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.ManagerRepository;

@Service
public class ManagerService {

	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	public void saveManager(Managers manager) {
		managerRepository.save(manager);
		
	}

	
	public Managers findManagerById(String email) {
		Managers manager = managerRepository.findById(email).orElse(null);
		return manager;
	}


	public void deleteManager(Managers manager) {
		managerRepository.delete(manager);
		
	}


	public Boolean validateManager(String managerEmail, String managerPassword) {
		System.out.println(managerEmail + " --- "+managerPassword);
		if (managerRepository.findById(managerEmail).isPresent()) {
			Managers manager= managerRepository.findById(managerEmail).get();
			String dbPassword = manager.getManagerPassword().toString();
			if (dbPassword.equals(managerPassword)) {
				return true;
			}
		}
		return false;
	}

	public List<Complaints> findComplaintByPincode(String managerPincode) {
		return complaintRepository.findComplaintByPincode(managerPincode);
	}
}
