package com.quizzbattle.quizzbattlebackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.quizzbattle.quizzbattlebackend.model.User;
import com.quizzbattle.quizzbattlebackend.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public UserDetails loadUserByUsername(String username) {

		User user = userRepository.findByUsername(username);
		return new UserDetailsImpl(user);
	}

}
