package com.psa.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psa.test.dao.TestDAO;
import com.psa.test.entities.Question;
import com.psa.test.entities.QuestionOptions;
import com.psa.test.entities.User;
import com.psa.test.exception.TestException;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	TestDAO dao;
	
	@Override
	public String asei() {
		return dao.asei();
	}

	@Override
	public User validate(User user) {
		return dao.validate(user);
	}

	@Override
	public Question addQuestion(Question ques) {
		return dao.addQuestion(ques);
	}

	@Override
	public List<Question> getQuestions() {
		return dao.getQuestions();
	}

	@Override
	public QuestionOptions addOption(QuestionOptions opt) {
		return dao.addOption(opt);
	}

	@Override
	public List<QuestionOptions> getQuestionOptions(Question ques) {
		return dao.getQuestionOptions(ques);
	}

	@Override
	public Question getQuestion(int qId) {
		return dao.getQuestion(qId);
	}

	@Override
	public User register(User user) throws TestException{
		return dao.register(user);
	}
	
	
}
