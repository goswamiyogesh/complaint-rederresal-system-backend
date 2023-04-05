package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Engineers;
import com.example.demo.repository.EngineerRepository;

@Service
public class EngineerService {
	@Autowired
	EngineerRepository engineerRepository;


	public List<Engineers> fetchAllEngineers() {
		return engineerRepository.findAll();
	}

	
	public void saveEngineer(Engineers engineer) {
		engineerRepository.save(engineer);
		
	}

	
	public Engineers findEngineerById(String email) {
		Engineers engineer = engineerRepository.findById(email).orElse(null);
		return engineer;
	}

	public void deleteEngineer(Engineers engineer) {
		engineerRepository.delete(engineer);
		
	}

	
	public Boolean validateEngineer(String engineerEmail, String engineerPassword) {
		System.out.println(engineerEmail + " --- "+engineerPassword);
		if (engineerRepository.findById(engineerEmail).isPresent()) {
			Engineers engineer= engineerRepository.findById(engineerEmail).get();
			String dbPassword = engineer.getEngineerPassword().toString();
			if (dbPassword.equals(engineerPassword)) {
				return true;
			}
		}
		return false;
	}
}
