package com.sports.tennis.controller;

import com.sports.tennis.dao.GameRepository;
import com.sports.tennis.domain.Game;
import com.sports.tennis.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;

    @GetMapping("/game/{id}")
    public Game retrieveGame(@PathVariable long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.get();
    }

    @PostMapping("/game")
    public ResponseEntity<Object> createGame(@RequestBody Game game) {
        Game savedGame = gameRepository.save(game);
        savedGame.setScore("Love-Love");
        return new ResponseEntity<>(savedGame, HttpStatus.OK);
    }

    @PostMapping("/score/{gameId}/{playerId}")
    public ResponseEntity<Object> score(@PathVariable long gameId, @PathVariable long playerId) {
        Game updatedGame = gameService.scoreDriver(gameId, playerId);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);
    }

    @DeleteMapping("/game/{id}")
    public void deleteGame(@PathVariable long id) {
        gameRepository.deleteById(id);
    }
}
