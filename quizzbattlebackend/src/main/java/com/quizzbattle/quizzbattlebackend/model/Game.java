package com.quizzbattle.quizzbattlebackend.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* JPA annotations */
@Entity
@Table(name = "game")

/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
public class Game {

    public static final String ONGOING = "ONGOING";
    public static final String FINISHED = "FINISHED";

    public enum Status {
        ONGOING, FINISHED
    }

    /* JPA: ID with auto-increment */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* JPA: Relationship with Player (Player 1) */
    @Valid
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "player1_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Player1 cannot be null")
    private Player player1;

    /* JPA: Relationship with Player (Player 2) */
    @Valid
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "player2_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Player2 cannot be null")
    private Player player2;

    /* JPA: Status field (enum mapped as String) */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @NotNull(message = "Status cannot be null")
    private Status status;

    /* JPA: Relationship with Player (Turn) */
    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turn", referencedColumnName = "id")
    private Player turn;

    /* JPA: Score for Player 1 */
    @Positive(message = "Score must be positive")
    @Column(name = "score_player1", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int scorePlayer1 = 0;

    /* JPA: Score for Player 2 */
    @Positive(message = "Score must be positive")
    @Column(name = "score_player2", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int scorePlayer2 = 0;

    /* JPA: Stars for Player 1 */
    @Positive(message = "Stars must be positive")
    @Column(name = "stars_player1", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int starsPlayer1 = 0;

    /* JPA: Stars for Player 2 */
    @Positive(message = "Stars must be positive")
    @Column(name = "stars_player2", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int starsPlayer2 = 0;

    /* JPA: Relationship with Player (Winner) */
    @Valid
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "winner_id", referencedColumnName = "id")
    private Player winner;

    /* Método para asignar turno por */
    @PrePersist
    private void assignDefaultTurn() {
        if (this.turn == null) {
            this.turn = this.player1;  // Si no se asigna ningún turno, se asigna el turno al player1
        }
    }
}
