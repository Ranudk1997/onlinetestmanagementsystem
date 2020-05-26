package com.cg.QuestionsModule.service;

import java.util.List;

import com.cg.QuestionsModule.entity.Questions;

/***************************************************************************************************
 * @author        Harshit Singhal
 * Description    It is service interface that provide the methods for adding new question , show all
 *                questions and deleting question and further implemented by service implementation 
 *                    
 *Created Date    11-MAY-2020                
 ****************************************************************************************************/

public interface QuestionsInterface {
	boolean addQuestion(Questions questions);

	void deleteQuestion(Integer questionId);

	List<Questions> show();

	Questions updateQuestion(Questions questions);

}
