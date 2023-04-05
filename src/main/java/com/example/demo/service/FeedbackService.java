package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Feedbacks;
import com.example.demo.repository.FeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	
	
	public List<Feedbacks> fetchAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	
	public void saveFeedback(Feedbacks feedback) {
		feedbackRepository.save(feedback);
		
	}

	public Feedbacks findFeedbackById(int feedbackId) {
		Feedbacks feedback = feedbackRepository.findById(feedbackId).orElse(null);
		return feedback;
	}

	public void deleteFeedback(Feedbacks feedback) {
		feedbackRepository.delete(feedback);
		
	}
}
