package com.sports.tennis.service;

import com.sports.tennis.dao.GameRepository;
import com.sports.tennis.dao.PlayerRepository;
import com.sports.tennis.domain.Game;
import com.sports.tennis.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;

public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public void scoreDriver(long gameId, long playerId) {

        Game game = gameRepository.findById(gameId).orElse(null);
        Player player = playerRepository.findById(playerId).orElse(null);

        if (game != null && player != null) {
            // check which player's score to increment
            if (game.getPlayer1().equals(player.getName())) {
                game.setScore(incrementScore(player));
            } else if (game.getPlayer2().equals(player.getName())) {
                game.setScore(incrementScore(player));
            }
        }
    }

    private String incrementScore(Player player) {
        return null;
    }
}
