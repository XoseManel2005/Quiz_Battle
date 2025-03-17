package com.quizzbattle.quizzbattlebackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Operation(summary = "Test Swagger", description = "Endpoint vacío para que Swagger lo detecte")
    @ApiResponse(responseCode = "200", description = "Swagger funcionando correctamente")
    @GetMapping("/test")
    public String testSwagger() {
        return "Swagger está funcionando";
    }
}
