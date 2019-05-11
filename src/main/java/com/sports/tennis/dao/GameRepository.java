package com.sports.tennis.dao;

import com.sports.tennis.domain.Game;
import com.sports.tennis.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

}
