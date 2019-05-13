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
        Player player = playerRepository.findById(playerId).orElse(null);

        if (game != null && player != null) {
            // check which player's score to increment
            if (game.getPlayer1().equals(player.getName())) {
                game.setScore(incrementScore(true, game, player));
            } else if (game.getPlayer2().equals(player.getName())) {
                game.setScore(incrementScore(false, game, player));
            }
        }

        return game;
    }

    private String incrementScore(Boolean player1Scored, Game game, Player player) {
        if (game.getScore().equals("Love-Love")) {
            if (player1Scored) {
                game.setScore("15-Love");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Love-15");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("15-Love")) {
            if (player1Scored) {
                game.setScore("30-Love");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("15-15");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("Love-15")) {
            if (player1Scored) {
                game.setScore("15-15");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Love-30");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("30-Love")) {
            if (player1Scored) {
                game.setScore("40-Love");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("30-15");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("Love-30")) {
            if (player1Scored) {
                game.setScore("15-30");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Love-40");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("40-Love")) {
            if (player1Scored) {
                game.setScore("Player 1: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("40-15");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("Love-40")) {
            if (player1Scored) {
                game.setScore("15-40");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Player 2: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("15-15")) {
            if (player1Scored) {
                game.setScore("30-15");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("15-30");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("30-30")) {
            if (player1Scored) {
                game.setScore("40-30");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("30-40");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("15-30")) {
            if (player1Scored) {
                game.setScore("30-30");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("15-40");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("30-15")) {
            if (player1Scored) {
                game.setScore("40-15");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("30-30");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("15-40")) {
            if (player1Scored) {
                game.setScore("30-40");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Player 2: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("40-15")) {
            if (player1Scored) {
                game.setScore("Player 1: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("40-30");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("30-40")) {
            if (player1Scored) {
                game.setScore("Deuce");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Player 2: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("40-30")) {
            if (player1Scored) {
                game.setScore("Player 1: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Deuce");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("Deuce")) {
            if (player1Scored) {
                game.setScore("Player 1 Advantage");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Player 2 Advantage");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("Player 1 Advantage")) {
            if (player1Scored) {
                game.setScore("Player 1: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Deuce");
                gameRepository.saveAndFlush(game);
            }
        } else if (game.getScore().equals("Player 2 Advantage")) {
            if (player1Scored) {
                game.setScore("Deuce");
                gameRepository.saveAndFlush(game);
            } else {
                game.setScore("Player 2: " + player.getName() + " Wins");
                gameRepository.saveAndFlush(game);
            }
        }
        return game.getScore();
    }
}
