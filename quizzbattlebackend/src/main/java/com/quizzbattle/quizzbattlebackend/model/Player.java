package com.quizzbattle.quizzbattlebackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* JPA annotations */
@Entity
@DiscriminatorValue(User.PLAYER)

/* Lombok */
@Data
@NoArgsConstructor
//@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Player extends User {

    private static final long serialVersionUID = 1L;
    
    /* ID de Google (opcional, si inicia sesión con Google) */
    @Column(name = "google_id", unique = true)
    protected String googleId;

    /* Token para notificaciones push (FCM) */
    @Column(name = "fcm_token", columnDefinition = "TEXT")
    protected String fcmToken;

    /* Foto de perfil (URL) */
    @Column(name = "profile_picture", columnDefinition = "TEXT")
    protected String profilePicture;

    @Override
    public String getInfo() {
        return "Player: " + username + " (" + email + ")";
    }
}
