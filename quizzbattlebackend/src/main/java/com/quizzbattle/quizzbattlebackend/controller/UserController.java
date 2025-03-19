package com.quizzbattle.quizzbattlebackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "User API")

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    @Operation(summary = "Test Swagger", description = "Endpoint vacío para que Swagger lo detecte")
    @ApiResponse(responseCode = "200", description = "Swagger funcionando correctamente")
    @GetMapping("/test")
    public String testSwagger() {
        return "Swagger está funcionando";
    }
}
