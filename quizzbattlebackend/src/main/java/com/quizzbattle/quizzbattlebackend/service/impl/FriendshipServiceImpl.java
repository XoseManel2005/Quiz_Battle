package com.quizzbattle.quizzbattlebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.quizzbattle.quizzbattlebackend.model.Friendship;
import com.quizzbattle.quizzbattlebackend.model.Friendship.Status;
import com.quizzbattle.quizzbattlebackend.repository.FriendshipRepository;
import com.quizzbattle.quizzbattlebackend.model.Player;
import com.quizzbattle.quizzbattlebackend.service.FriendshipService;

public class FriendshipServiceImpl implements FriendshipService {

	@Autowired
	private FriendshipRepository friendshipRepository;

	@Override
	public List<Friendship> findAll(Player player) {
		return friendshipRepository.findAllByFilters(player);
	}

	@Override
	public List<Friendship> findAllByReciverAndStatus(Player player, Status status) {
		return friendshipRepository.findAllByReciverAndStatus(player, status);
	}

}
