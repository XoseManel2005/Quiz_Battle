package com.quizzbattle.quizzbattlebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.quizzbattle.quizzbattlebackend.model.User;
import com.quizzbattle.quizzbattlebackend.repository.UserRepository;
import com.quizzbattle.quizzbattlebackend.security.JwtUtils;
import com.quizzbattle.quizzbattlebackend.service.UserService;

import cat.institutmarianao.sailing.ws.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public List<User> findAll(String username) {
		return userRepository.findAllByFilters(username);
	}

	@Override
	public User getByUsername(@NotBlank String username) {
		return userRepository.findByUsername(username);

	}

	@Override
	public User save(@NotNull @Valid User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(@NotNull @Valid User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
