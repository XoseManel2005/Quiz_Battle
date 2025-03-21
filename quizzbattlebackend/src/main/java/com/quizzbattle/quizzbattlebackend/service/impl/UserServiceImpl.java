package com.quizzbattle.quizzbattlebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.quizzbattle.quizzbattlebackend.model.User;
import com.quizzbattle.quizzbattlebackend.repository.UserRepository;
import com.quizzbattle.quizzbattlebackend.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageSource messageSource;

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
		if (userRepository.existsByUsername(user.getUsername())) 
			throw new ValidationException (messageSource.getMessage("error.UserService.username.exists", new String[] { user.getUsername() }, LocaleContextHolder.getLocale()));
		
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User update(@NotNull @Valid User user) {
		User dbUser = userRepository.findByUsername(user.getUsername());
		
		if (dbUser == null) {
			throw new ValidationException(messageSource.getMessage(
					"error.UserService.username.not.found", 
					new String[] { user.getUsername() }, 
					LocaleContextHolder.getLocale()));
		}

		// Si la contraseña es diferente de null, la actualiza
		if (user.getPassword() != null) {
			dbUser.setPassword(user.getPassword());
		}

		// Si el email no es null, lo actualiza
		if (user.getEmail() != null) {
			dbUser.setEmail(user.getEmail());
		}

		// Si tiene una foto de perfil nueva, la actualiza
		if (user.getProfilePicture() != null) {
			dbUser.setProfilePicture(user.getProfilePicture());
		}

		// Si el token FCM ha cambiado, lo actualiza
		if (user.getFcmToken() != null) {
			dbUser.setFcmToken(user.getFcmToken());
		}

		// Guarda los cambios
		return userRepository.save(dbUser);
	}

}
