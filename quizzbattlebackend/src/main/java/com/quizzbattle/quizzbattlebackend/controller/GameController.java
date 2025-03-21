package com.quizzbattle.quizzbattlebackend.controller;

import java.util.List;

import com.quizzbattle.quizzbattlebackend.model.Game;
import com.quizzbattle.quizzbattlebackend.model.Player;
import com.quizzbattle.quizzbattlebackend.service.GameService;
import com.quizzbattle.quizzbattlebackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Game", description = "Game API")
@RestController
@RequestMapping("/games")
@SecurityRequirement(name = "Bearer Authentication")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @Operation(summary = "Find all games filtered by player", 
               description = "Retrieve all games where the given player participates, ordered by turn")
    @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Game.class)))
    }, description = "Games retrieved successfully")
    @GetMapping("/find/all")
    public List<Game> findAll(
        @Parameter(description = "Username of the player", required = true)
        @RequestParam(value = "username") String username) {
        
        Player player = (Player) userService.getByUsername(username);
        return gameService.findAll(player);
    }
}
