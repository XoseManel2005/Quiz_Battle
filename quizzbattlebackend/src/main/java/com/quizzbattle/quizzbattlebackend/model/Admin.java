package com.quizzbattle.quizzbattlebackend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* JPA annotations */
@Entity
@DiscriminatorValue(User.ADMIN)

/* Lombok */
@Data
@NoArgsConstructor
//@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Admin extends User {

    private static final long serialVersionUID = 1L;

    @Override
    public String getInfo() {
        return "Administrador: " + this.email;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
