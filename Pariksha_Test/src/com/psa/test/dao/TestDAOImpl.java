package com.psa.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.psa.test.entities.Question;
import com.psa.test.entities.QuestionOptions;
import com.psa.test.entities.User;
import com.psa.test.exception.TestException;

@Repository
@Transactional
public class TestDAOImpl implements TestDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String asei() {
		return "Hello";
	}

	@Override
	public User validate(User user) {
		TypedQuery<User> query = entityManager
				.createQuery(
						"select users from User users where users.username=:pusername and users.password=:ppwd",
						User.class);
		query.setParameter("pusername", user.getUsername());
		query.setParameter("ppwd", user.getPassword());
		user = query.getSingleResult();
		return user;
	}

	@Override
	public Question addQuestion(Question ques) {
		entityManager.persist(ques);
		;
		entityManager.flush();
		return ques;
	}

	@Override
	public QuestionOptions addOption(QuestionOptions opt) {
		entityManager.persist(opt);
		;
		entityManager.flush();
		return opt;
	}

	@Override
	public List<Question> getQuestions() {
		TypedQuery<Question> query = entityManager.createQuery(
				"select q from Question q", Question.class);
		return query.getResultList();
	}

	@Override
	public List<QuestionOptions> getQuestionOptions(Question ques) {
		TypedQuery<QuestionOptions> query = entityManager
				.createQuery(
						"select option from QuestionOptions option where questionId=:qId",
						QuestionOptions.class);
		query.setParameter("qId", ques.getQuestionId());
		return query.getResultList();
	}

	@Override
	public Question getQuestion(int qId) {
		TypedQuery<Question> query = entityManager.createQuery(
				"select ques from Question ques where ques.questionId=:quesId",
				Question.class);
		query.setParameter("quesId", qId);
		return query.getSingleResult();
	}

	@Override
	public User register(User user) throws TestException{
		try{
		entityManager.persist(user);
		entityManager.flush();
		return user;
		}catch(Exception e){
			throw new TestException("Registration Successful: Username already exists");
		}
	}
}
