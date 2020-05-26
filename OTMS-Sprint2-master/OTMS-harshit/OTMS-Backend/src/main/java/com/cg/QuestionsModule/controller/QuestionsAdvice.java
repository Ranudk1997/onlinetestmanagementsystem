package com.cg.QuestionsModule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.QuestionsModule.exception.ErrorInfo;
import com.cg.QuestionsModule.exception.QuestionsException;

@RestControllerAdvice
public class QuestionsAdvice {
	
		@ExceptionHandler(value = {QuestionsException.class})
		@ResponseStatus(code=HttpStatus.BAD_REQUEST)
		public ErrorInfo handleException1(Exception ex) {
			return new ErrorInfo(ex.getMessage());
		}

}