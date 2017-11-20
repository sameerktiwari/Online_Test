package com.psa.test.dao;

import java.util.List;

import com.psa.test.entities.Question;
import com.psa.test.entities.User;

public interface TestDAO {
	String asei();

	User validate(User user);

	Question addQuestion(Question ques);

	List<Question> getQuestions();
}
