package com.quizzbattle.quizzbattlebackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.quizzbattle.quizzbattlebackend.model.Friendship;
import com.quizzbattle.quizzbattlebackend.model.Friendship.Status;
import com.quizzbattle.quizzbattlebackend.repository.FriendshipRepository;
import com.quizzbattle.quizzbattlebackend.model.Player;
import com.quizzbattle.quizzbattlebackend.service.FriendshipService;

@Validated
@Service
public class FriendshipServiceImpl implements FriendshipService {

	@Autowired
	private FriendshipRepository friendshipRepository;

	@Override
	public List<Friendship> findAll(Player player) {
		return friendshipRepository.findAllByFilters(player);
	}

	@Override
	public List<Friendship> findAllByReceiverAndStatus(Player player, Status status) {
		return friendshipRepository.findAllByReceiverAndStatus(player, status);
	}

}
