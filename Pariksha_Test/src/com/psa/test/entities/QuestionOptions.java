package com.psa.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question_options")
public class QuestionOptions {
	@Id
	@Column(name = "optionId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int optionId;

	@Column(name = "ansDescription")
	String ansDescription;

	@Column(name = "questionId")
	int questionId;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getAnsDescription() {
		return ansDescription;
	}

	public void setAnsDescription(String ansDescription) {
		this.ansDescription = ansDescription;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	
}
