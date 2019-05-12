package com.sports.tennis.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private long id;
    private String score;
    private String player1;
    private String player2;

    public Game() {
        super();
    }

    public Game(Long id, String score, String player1, String player2) {
        super();
        this.id = id;
        this.score = score;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }
}
