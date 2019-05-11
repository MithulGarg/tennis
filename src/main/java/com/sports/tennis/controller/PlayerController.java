package com.sports.tennis.controller;

import com.sports.tennis.dao.PlayerRepository;
import com.sports.tennis.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/player")
    public List<Player> retrieveAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Player retrievePlayer(@PathVariable long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.get();
    }

    @PostMapping("/player")
    public ResponseEntity<Object> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerRepository.save(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable long id) {
        playerRepository.deleteById(id);
    }
}
