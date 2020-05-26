package com.cg.QuestionsModule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*********************************************************************************************************************
 * @author Harshit Singhal Description It is a entity class of questions Created
 *         Date 06-MAY-2020
 ********************************************************************************************************************/

@Entity
@Table(name = "Questions_table")


public class Questions {
	@Id
	@Column(name = "QuestionsId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_seq")
	@SequenceGenerator(sequenceName = "questions_seq", initialValue = 1, allocationSize = 1, name = "questions_seq")
	private Integer questionsId;

	@Column(name = "QuestionsTitle")
	private String questionsTitle;

	@Column(name = "QuestionsOptions")
	private String questionsOptions;

	@Column(name = "QuestionsAnswer")
	private Integer questionsAnswer;

	@Column(name = "QuestionsMarks")
	private Integer questionsMarks;



	public Integer getQuestionsId() {
		return questionsId;
	}

	public String getQuestionsTitle() {
		return questionsTitle;
	}

	public String getQuestionsOptions() {
		return questionsOptions;
	}

	public Integer getQuestionsAnswer() {
		return questionsAnswer;
	}

	public Integer getQuestionsMarks() {
		return questionsMarks;
	}

	public Questions(Integer questionsId, String questionsTitle, String questionsOptions, Integer questionsAnswer,
			Integer questionsMarks) {
		super();
		this.questionsId = questionsId;
		this.questionsTitle = questionsTitle;
		this.questionsOptions = questionsOptions;
		this.questionsAnswer = questionsAnswer;
		this.questionsMarks = questionsMarks;
	
	}

	@Override
	public String toString() {
		return "Questions [questionsId=" + questionsId + ", questionsTitle=" + questionsTitle + ", questionsOptions="
				+ questionsOptions + ", questionsAnswer=" + questionsAnswer + ", questionsMarks=" + questionsMarks
				 + "]";
	}

	public Questions() {
		super();
	}
}
