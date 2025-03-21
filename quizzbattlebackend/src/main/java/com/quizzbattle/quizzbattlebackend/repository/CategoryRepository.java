package com.quizzbattle.quizzbattlebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizzbattle.quizzbattlebackend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findByName(String name);

}
