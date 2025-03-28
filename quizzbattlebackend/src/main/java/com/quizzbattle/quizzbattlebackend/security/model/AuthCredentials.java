package com.quizzbattle.quizzbattlebackend.security.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthCredentials {
	@NonNull
	private String username;
	@NonNull
	private String password;
}

