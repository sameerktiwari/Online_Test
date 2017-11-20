package com.psa.test.service;

import java.util.List;

import com.psa.test.entities.Question;
import com.psa.test.entities.User;

public interface TestService {
	String asei();
	
	User validate(User user);
	
	Question addQuestion(Question ques);
	
	List<Question> getQuestions();
}
