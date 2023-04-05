package com.example.demo.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Complaints;
import com.example.demo.model.EngineerDuty;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.EngineerDutyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/engineerDuty")
public class EngineerDutyController {
	@Autowired
	EngineerDutyService engineerDutyService;
	
	@Autowired
	ComplaintService complaintService;
	
	

	@PostMapping("/addEngineerDuty")
	public boolean addEngineerDuty(@RequestBody Object engineersDutyAssigned) throws NoSuchFieldException{
		int ticketId = (int) ((LinkedHashMap)engineersDutyAssigned).get("ticketId");
		String customerEmail = (String)((LinkedHashMap) engineersDutyAssigned).get("customerEmail");
		String selectedEngineer = (String)((LinkedHashMap) engineersDutyAssigned).get("selectedEngineer");
		System.out.println(ticketId+"---"+customerEmail+"--"+selectedEngineer);
		
		EngineerDuty existingEngineersDuty = engineerDutyService.getEngineerAssignedByTicketId(ticketId);
		if (existingEngineersDuty==null) {
			
			EngineerDuty engineerDuty = new EngineerDuty();
			
			engineerDuty.setTicketId(ticketId);
			engineerDuty.setCustomerEmail(customerEmail);
			engineerDuty.setEngineerEmail(selectedEngineer);
			
			engineerDutyService.saveEngineerDuty(engineerDuty);
			return true;
		}
		return false;
	}
	@PostMapping("/updateStatus")
	public boolean updateStatus(@RequestBody Object statusUpdate)throws NoSuchFieldException{
		int ticketId = (int) ((LinkedHashMap)statusUpdate).get("ticketId");
		String newStatus = (String)((LinkedHashMap) statusUpdate).get("status");
		System.out.println("------------"+newStatus);
		Complaints complaint = complaintService.findComplaintById(ticketId);
		if(complaint!=null) {
			complaint.setStatus(newStatus);
			complaintService.saveComplaint(complaint);
			return true;
		}
		return false;
	}
}
