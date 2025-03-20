package com.quizzbattle.quizzbattlebackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.quizzbattle.quizzbattlebackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE "
            + "(u.username LIKE %:username% OR :username IS NULL) "
            + "ORDER BY u.username ASC")
    List<User> findAllByFilters(String username);
    
    User findByUsername(String username);

}
