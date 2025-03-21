package com.quizzbattle.quizzbattlebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizzbattle.quizzbattlebackend.model.Game;
import com.quizzbattle.quizzbattlebackend.model.Player;
import com.quizzbattle.quizzbattlebackend.repository.GameRepository;
import com.quizzbattle.quizzbattlebackend.service.GameService;

@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public List<Game> findAll(Player player) {
		
		return gameRepository.findAllByPlayerOrderedByTurn(player);
	}

}
