package com.quizzbattle.quizzbattlebackend.service;

import java.util.List;

import com.quizzbattle.quizzbattlebackend.model.User;
import com.quizzbattle.quizzbattlebackend.model.User.Role;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface UserService {
	
	List<User> findAll(Role[] roles, String username);
	
	User getByUsername(@NotBlank String username);
	
	User save(@NotNull @Valid User user);
	
	User update(@NotNull @Valid User user);

}
