package com.cg.QuestionsModule.controller;

import java.util.List;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.QuestionsModule.entity.Questions;
import com.cg.QuestionsModule.exception.QuestionsException;
import com.cg.QuestionsModule.service.QuestionsInterface;
import com.cg.QuestionsModule.service.QuestionsService;

/**************************************************************************************************************
 *          @author          Harshit Singhal
 *          Description      It is a controller class that provides the methods for adding a new question, 
                             delete a question, update a question and viewing all the questions  
 *          Created Date    09-MAY-2020
 *************************************************************************************************************/


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Questionscontroller {
	@Autowired
	private QuestionsInterface questionsservice;

	
	/***************************************************************************************************
	 * Method       addquestions
	 * Description  To add the questions inserted in the database
	 * 
	 * Created By    Harshit Singhal
	 * Created Date   08-MAY-2020
	 *****************************************************************************************************/

	@PostMapping("/addquestion")
	public ResponseEntity<String> addQuestions(@Valid @RequestBody Questions question, BindingResult br)
			throws QuestionsException {
		System.out.println("**uestion JSON data"+question);
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new QuestionsException(err);
		}
		try {
			questionsservice.addQuestion(question);
			return new ResponseEntity<String>("Question added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new QuestionsException("ID already exists");
		}
	}
	
	/***************************************************************************************************
	 * Method       viewquestions
	 * Description  To get all the questions inserted in the database
	 *
	 * Created By    Harshit Singhal
	 * Created Date   09-MAY-2020
	 *****************************************************************************************************/

	
	@GetMapping("/viewquestions")
	public ResponseEntity<List<Questions>> getQuestionslist() {
		List<Questions> questionsList = questionsservice.show();
		return new ResponseEntity<List<Questions>>(questionsList, HttpStatus.OK);
	}
	
	/***************************************************************************************************
	 * Method       deletequestions
	 * Description  To delete the questions by questionsId 
	 * 
	 * Created By    Harshit Singhal
	 * Created Date   09-MAY-2020
	 *****************************************************************************************************/
	

	@DeleteMapping("/deletequestion/{questionsId}")
	public ResponseEntity<String> deletequestions( @PathVariable Integer questionsId) throws QuestionsException
	{
		try
		{
			questionsservice.deleteQuestion( questionsId);
			return new ResponseEntity<String>("Question is deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new QuestionsException("Question ID  doesnot exists");
		}
	}
	
	/***************************************************************************************************
	 * Method       updatequestions
	 * Description  To update the questions by questionsId 
	 * 
	 * Created By    Harshit Singhal
	 * Created Date   09-MAY-2020
	 *****************************************************************************************************/
	

	@PutMapping("/updatequestion")
	public ResponseEntity<String> updateQuestion(@Valid @RequestBody Questions question,BindingResult br ) throws QuestionsException
	{
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new QuestionsException(err);
		}
		try {
			questionsservice.updateQuestion(question);
			return new ResponseEntity<String>("Questions updated successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new QuestionsException("Question ID already exists");
		}
	}
	
		
	}