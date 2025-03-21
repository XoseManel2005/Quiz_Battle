package com.quizzbattle.quizzbattlebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizzbattle.quizzbattlebackend.model.Game;
import com.quizzbattle.quizzbattlebackend.model.Player;
import com.quizzbattle.quizzbattlebackend.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public class GameController {
	@Autowired
	private GameService gameService;

	/* Swagger */
	@Operation(summary = "Find all games filtered", description = "Retrieve all games filtered from the database.")
	@ApiResponse(responseCode = "200", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Game.class))) }, description = "Games retrieved ok")
	/**/
	@GetMapping("/find/all")
	public List<Game> findAll(@RequestParam(value = "category", required = false) Player player) {
		
		return gameService.findAll(player);
	}
}
