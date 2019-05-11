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
    private Player player1;
    private Player player2;
}
