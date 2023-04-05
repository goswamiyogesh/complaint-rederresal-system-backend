package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EngineerDuty;
@Repository
public interface EngineerDutyRepository extends JpaRepository<EngineerDuty, Integer>{

	
	List<EngineerDuty> findEngineerDutyByEngineerEmail(String engineerEmail);

	EngineerDuty findEngineerDutyByTicketId(int ticketId);

}
