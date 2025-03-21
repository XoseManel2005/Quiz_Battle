package com.quizzbattle.quizzbattlebackend.service;

import java.util.List;
import com.quizzbattle.quizzbattlebackend.model.Game;
import com.quizzbattle.quizzbattlebackend.model.Player;

public interface GameService {

	List<Game> findAll(Player player);
	
}
