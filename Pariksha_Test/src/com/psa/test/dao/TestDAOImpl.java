package com.psa.test.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.psa.test.entities.Question;
import com.psa.test.entities.User;


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
		TypedQuery<User> query = entityManager.createQuery("select users from User users where users.username=:pusername and users.password=:ppwd",
				User.class);
		query.setParameter("pusername", user.getUsername());
		query.setParameter("ppwd", user.getPassword());
		user = query.getSingleResult();
		return user;
	}
	
	@Override
	public Question addQuestion(Question ques) {
		entityManager.persist(ques);;
		entityManager.flush();
		return ques;
	}
	
	@Override
	public List<Question> getQuestions() {
		TypedQuery<Question> query = entityManager.createQuery(
				"select q from Question q", Question.class);
		return query.getResultList();
	}
}
