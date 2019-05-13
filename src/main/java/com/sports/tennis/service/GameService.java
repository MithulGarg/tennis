package com.sports.tennis.service;

import com.sports.tennis.dao.GameRepository;
import com.sports.tennis.dao.PlayerRepository;
import com.sports.tennis.domain.Game;
import com.sports.tennis.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Game scoreDriver(long gameId, long playerId) {

        Game game = gameRepository.findById(gameId).orElse(null);
        game.setScore("Love-Love");
        Player player = playerRepository.findById(playerId).orElse(null);

        if (game != null && player != null) {
            // check which player's score to increment
            if (game.getPlayer1().equals(player.getName())) {
                game.setScore(incrementScore(true, game));
            } else if (game.getPlayer2().equals(player.getName())) {
                game.setScore(incrementScore(false, game));
            }
        }

        return game;
    }

    private String incrementScore(Boolean player1Scored, Game game) {
        if (game.getScore().equals("Love-Love")) {
            if (player1Scored) {
                game.setScore("15-Love");
            } else {
                game.setScore("Love-15");
            }
        } else if (game.getScore().equals("15-Love")) {
            if (player1Scored) {
                game.setScore("30-Love");
            } else {
                game.setScore("15-15");
            }
        } else if (game.getScore().equals("Love-15")) {
            if (player1Scored) {
                game.setScore("15-15");
            } else {
                game.setScore("Love-30");
            }
        } else if (game.getScore().equals("30-Love")) {
            if (player1Scored) {
                game.setScore("40-Love");
            } else {
                game.setScore("30-15");
            }
        } else if (game.getScore().equals("Love-30")) {
            if (player1Scored) {
                game.setScore("15-30");
            } else {
                game.setScore("Love-40");
            }
        } else if (game.getScore().equals("40-Love")) {
            if (player1Scored) {
                game.setScore("Player 1 Wins");
            } else {
                game.setScore("40-15");
            }
        } else if (game.getScore().equals("Love-40")) {
            if (player1Scored) {
                game.setScore("15-40");
            } else {
                game.setScore("Player 2 Wins");
            }
        } else if (game.getScore().equals("15-15")) {
            if (player1Scored) {
                game.setScore("30-15");
            } else {
                game.setScore("15-30");
            }
        } else if (game.getScore().equals("30-30")) {
            if (player1Scored) {
                game.setScore("40-30");
            } else {
                game.setScore("30-40");
            }
        } else if (game.getScore().equals("15-30")) {
            if (player1Scored) {
                game.setScore("30-30");
            } else {
                game.setScore("15-40");
            }
        } else if (game.getScore().equals("30-15")) {
            if (player1Scored) {
                game.setScore("40-15");
            } else {
                game.setScore("30-30");
            }
        } else if (game.getScore().equals("15-40")) {
            if (player1Scored) {
                game.setScore("30-40");
            } else {
                game.setScore("Player 2 Wins");
            }
        } else if (game.getScore().equals("40-15")) {
            if (player1Scored) {
                game.setScore("Player 1 Wins");
            } else {
                game.setScore("40-30");
            }
        } else if (game.getScore().equals("30-40")) {
            if (player1Scored) {
                game.setScore("Deuce");
            } else {
                game.setScore("Player 2 Wins");
            }
        } else if (game.getScore().equals("40-30")) {
            if (player1Scored) {
                game.setScore("Player 1 Wins");
            } else {
                game.setScore("Deuce");
            }
        } else if (game.getScore().equals("Deuce")) {
            if (player1Scored) {
                game.setScore("Player 1 Advantage");
            } else {
                game.setScore("Player 2 Advantage");
            }
        } else if (game.getScore().equals("Player 1 Advantage")) {
            if (player1Scored) {
                game.setScore("Player 1 Wins");
            } else {
                game.setScore("Deuce");
            }
        } else if (game.getScore().equals("Player 2 Advantage")) {
            if (player1Scored) {
                game.setScore("Deuce");
            } else {
                game.setScore("Player 2 Wins");
            }
        }
        return game.getScore();
    }
}
