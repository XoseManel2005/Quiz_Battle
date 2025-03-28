package com.quizzbattle.quizzbattlebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizzbattle.quizzbattlebackend.model.Friendship;
import com.quizzbattle.quizzbattlebackend.model.Friendship.Status;
import com.quizzbattle.quizzbattlebackend.model.Player;
import com.quizzbattle.quizzbattlebackend.service.FriendshipService;
import com.quizzbattle.quizzbattlebackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Friendship", description = "Friendship API")
@RestController
@RequestMapping("/friendship")
@SecurityRequirement(name = "Bearer Authentication")
@Validated
public class FriendshipController {

	@Autowired
	private FriendshipService friendshipService;
	
	@Autowired
    private UserService userService;

	@Operation(summary = "Find all friendships filtered by player", description = "Retrieve all friendships from player")
	@ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Friendship.class))) }, description = "Friendships retrieved successfully")
	@GetMapping("/find/all")
	public List<Friendship> findAll(
			@Parameter(description = "Username of the player", required = true) @RequestParam(value = "username") String username) {

		Player player = (Player) userService.getByUsername(username);
		return friendshipService.findAll(player);
	}
	
	@Operation(summary = "Find all friendships filtered by receiver & status", description = "Retrieve all friendships from receiver")
	@ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Friendship.class))) }, description = "Friendships retrieved successfully")
	@GetMapping("/find/by/player/status")
	public List<Friendship> findAllByReciverAndStatus(
			@Parameter(description = "Username of the receiver", required = true) @RequestParam(value = "username") String username,
			@RequestParam(value = "status", required = true) Status status) {

		Player player = (Player) userService.getByUsername(username);
		return friendshipService.findAllByReceiverAndStatus(player, status);
	}

}
