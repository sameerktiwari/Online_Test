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
	private int optionId;

	@Column(name = "ansDescription")
	private String ansDescription;

	@Column(name = "questionId")
	private int questionId;

	public int getQuesOpId() {
		return optionId;
	}

	public void setQuesOpId(int optionId) {
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
