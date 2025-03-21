package com.quizzbattle.quizzbattlebackend.service;

import java.util.List;

import com.quizzbattle.quizzbattlebackend.model.Category;
import com.quizzbattle.quizzbattlebackend.model.Question;

public interface QuestionService {

	List<Question> findAll(Category category);
	
}
