package com.quizzbattle.quizzbattlebackend.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.quizzbattle.quizzbattlebackend.PasswordSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* JPA annotations */
@Entity
@Table(name = "user", indexes = { 
    @Index(name = "idx_role", columnList = "role", unique = false),
    @Index(name = "idx_username", columnList = "username", unique = true),
    @Index(name = "idx_email", columnList = "email", unique = true)
})
/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /* Valores de rol */
    public static final String PLAYER = "PLAYER";
    public static final String ADMIN = "ADMIN";

    public enum Role {
        PLAYER, ADMIN
    }

    public static final int MIN_USERNAME = 4;
    public static final int MAX_USERNAME = 20;
    public static final int MIN_PASSWORD = 6;

    /* ID único */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    protected Long id;

    /* Nombre de usuario */
    @NotBlank
    @Size(min = MIN_USERNAME, max = MAX_USERNAME)
    @Column(unique = true, nullable = true)
    protected String username;

    /* Email */
    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    protected String email;

    /* Contraseña (Serializada para ocultarla en respuestas JSON) */
    @JsonSerialize(using = PasswordSerializer.class)
    @NotBlank
    @Size(min = MIN_PASSWORD)
    @Column(nullable = false)
    protected String password;

    /* ID de Google (opcional, si inicia sesión con Google) */
    @Column(unique = true)
    protected String googleId;

    /* Token para notificaciones push (FCM) */
    @Column(columnDefinition = "TEXT")
    protected String fcmToken;

    /* Foto de perfil (URL) */
    @Column(columnDefinition = "TEXT")
    protected String profilePicture;

    /* Rol */
    @NotNull
	/* JPA */
	@Enumerated(EnumType.STRING)
	@Column(name = "role", insertable = false, updatable = false, nullable = false)
	protected Role role;

    /* Fechas de registro y actualización */
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(nullable = false)
    protected LocalDateTime updatedAt;

    @Column
    protected LocalDateTime lastLogin;

    /* Métodos para actualizar fechas automáticamente */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    /* Métodos JSON */
    @JsonIgnore
    public boolean isAdmin() {
        return role == Role.ADMIN;
    }

    @JsonIgnore
    public boolean isPlayer() {
        return role == Role.PLAYER;
    }

    @JsonIgnore
    public String getInfo() {
        return "User: " + username + " (" + email + ")";
    }
}
