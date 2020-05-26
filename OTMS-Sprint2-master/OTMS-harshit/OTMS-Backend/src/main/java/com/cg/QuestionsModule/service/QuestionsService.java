package com.cg.QuestionsModule.service;
import java.util.List;

import javax.transaction.Transactional;

import com.cg.QuestionsModule.dao.Questionsdao;
import com.cg.QuestionsModule.entity.Questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuestionsService implements QuestionsInterface{
	@Autowired
	private Questionsdao questionsdao;
	

	
	@Override
	public void  deleteQuestion(Integer questionsId)
	{
		questionsdao.deleteById(questionsId);
	}
	@Override
	public List<Questions> show(){
		return questionsdao.findAll();
	}
	@Override
	public Questions updateQuestion(Questions questions)
	{
		return questionsdao.save(questions);
	}

	@Override
	public boolean addQuestion(Questions questions) {
		// TODO Auto-generated method stub
		return questionsdao.save(questions) !=null;
	}


	

}

