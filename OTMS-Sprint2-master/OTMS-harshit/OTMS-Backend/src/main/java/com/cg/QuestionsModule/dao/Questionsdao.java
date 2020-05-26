package com.cg.QuestionsModule.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.QuestionsModule.entity.Questions;

public interface Questionsdao extends JpaRepository<Questions, Integer> {

}
