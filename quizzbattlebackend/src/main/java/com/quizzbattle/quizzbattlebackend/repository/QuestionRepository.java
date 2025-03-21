package com.quizzbattle.quizzbattlebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quizzbattle.quizzbattlebackend.model.Category;
import com.quizzbattle.quizzbattlebackend.model.Question;
public interface QuestionRepository extends JpaRepository<Question, Long>{

	@Query("SELECT q FROM Question q WHERE q.category = ?1 OR ?1 IS NULL"
			+ " ORDER BY q.category")
	List<Question> findAllByFilters(Category category);
}
