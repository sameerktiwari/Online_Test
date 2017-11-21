package com.psa.test.dao;

import java.util.List;

import com.psa.test.entities.Question;
import com.psa.test.entities.QuestionOptions;
import com.psa.test.entities.User;
import com.psa.test.exception.TestException;

public interface TestDAO {
	String asei();

	User validate(User user);

	Question addQuestion(Question ques);

	List<Question> getQuestions();

	List<QuestionOptions> getQuestionOptions(Question ques);

	QuestionOptions addOption(QuestionOptions opt);

	Question getQuestion(int qId);

	User register(User user) throws TestException;
}
