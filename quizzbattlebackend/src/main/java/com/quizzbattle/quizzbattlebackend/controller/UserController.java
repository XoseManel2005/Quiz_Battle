package com.quizzbattle.quizzbattlebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.quizzbattle.quizzbattlebackend.model.User;
import com.quizzbattle.quizzbattlebackend.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "Bearer Authentication")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Find all users", description = "Retrieve all users filtered by username")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping("/find/all")
    public List<User> findAll(@RequestParam(value = "username", required = false) String username) {
        return userService.findAll(username);
    }

    @Operation(summary = "Get user by username", description = "Retrieve a user by their username")
    @ApiResponse(responseCode = "200", description = "User retrieved successfully")
    @ApiResponse(responseCode = "404", description = "User not found")
    @GetMapping("/{username}")
    public User getByUsername(@PathVariable @NotBlank String username) {
        return userService.getByUsername(username);
    }

    @Operation(summary = "Create a new user", description = "Save a new user in the database")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid user data")
    @PostMapping("/create")
    public User save(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @Operation(summary = "Update a user", description = "Update an existing user's details")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    @ApiResponse(responseCode = "404", description = "User not found")
    @PutMapping("/update")
    public User update(@RequestBody @Valid User user) {
        return userService.update(user);
    }
}
