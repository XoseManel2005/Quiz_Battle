package com.quizzbattle.quizzbattlebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.quizzbattle.quizzbattlebackend.model.Category;
import com.quizzbattle.quizzbattlebackend.repository.CategoryRepository;
import com.quizzbattle.quizzbattlebackend.service.CategoryService;

import jakarta.validation.constraints.NotBlank;

@Validated
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getByName(@NotBlank String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByName(name);
	}

}
