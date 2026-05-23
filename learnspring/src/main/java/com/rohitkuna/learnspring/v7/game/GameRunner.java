package com.rohitkuna.learnspring.v7.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    private Game game; // field Dependency Injection

    public void run(){
        System.out.println("Running game: "+game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
