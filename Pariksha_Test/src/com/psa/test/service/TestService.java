package com.psa.test.service;

import java.util.List;

import com.psa.test.entities.Question;
import com.psa.test.entities.QuestionOptions;
import com.psa.test.entities.User;
import com.psa.test.exception.TestException;

public interface TestService {
	String asei();
	
	User validate(User user);
	
	Question addQuestion(Question ques);
	
	List<Question> getQuestions();
	
	QuestionOptions addOption(QuestionOptions opt);
	
	List<QuestionOptions> getQuestionOptions(Question ques);
	
	Question getQuestion(int qId);
	
	User register(User user) throws TestException;
}
