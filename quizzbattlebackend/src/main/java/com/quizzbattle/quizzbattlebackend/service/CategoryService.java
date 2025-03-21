package com.quizzbattle.quizzbattlebackend.service;

import java.util.List;

import com.quizzbattle.quizzbattlebackend.model.Category;
import jakarta.validation.constraints.NotBlank;

public interface CategoryService {
	
	List<Category> findAll();

	Category getByName(@NotBlank String name);
	
}
