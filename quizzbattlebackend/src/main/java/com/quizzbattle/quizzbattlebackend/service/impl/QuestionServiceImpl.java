package com.quizzbattle.quizzbattlebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.quizzbattle.quizzbattlebackend.model.Category;
import com.quizzbattle.quizzbattlebackend.model.Question;
import com.quizzbattle.quizzbattlebackend.repository.QuestionRepository;
import com.quizzbattle.quizzbattlebackend.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public List<Question> findAll(Category category) {
		return questionRepository.findAllByFilters(category);
	}

}
