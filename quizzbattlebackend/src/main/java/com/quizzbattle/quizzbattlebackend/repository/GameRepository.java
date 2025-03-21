package com.quizzbattle.quizzbattlebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.quizzbattle.quizzbattlebackend.model.Game;
import com.quizzbattle.quizzbattlebackend.model.Player;

public interface GameRepository extends JpaRepository<Game, Long> {

	@Query("""
		    SELECT g FROM Game g 
		    WHERE (g.player1 = :player OR g.player2 = :player)
		    ORDER BY 
		        CASE 
		            WHEN g.turn = :player THEN 0 
		            WHEN g.turn IS NOT NULL THEN 1 
		            ELSE 2 
		        END
		""")
		List<Game> findAllByPlayerOrderedByTurn(Player player);


}
