package com.quizzbattle.quizzbattlebackend.service;

import java.util.List;

import com.quizzbattle.quizzbattlebackend.model.Friendship;
import com.quizzbattle.quizzbattlebackend.model.Friendship.Status;
import com.quizzbattle.quizzbattlebackend.model.Player;

public interface FriendshipService {
	
	List<Friendship> findAll(Player player);
	
	List<Friendship> findAllByReciverAndStatus(Player player, Status status);
}
