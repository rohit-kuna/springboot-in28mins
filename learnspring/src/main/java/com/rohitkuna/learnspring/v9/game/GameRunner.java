package com.rohitkuna.learnspring.v9.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private Game game;

    @Autowired
    public void setGame(Game game){
        System.out.println("Setter Injection triggered");
        this.game=game;
    }
    // Setter injection is auto triggered by Spring when we do getBean for GameRunner, it will look for the dependency and inject it
    // Autowired is necessary
    // without @Autowired, the instance is null
    // OP: Running game: null

    public void run(){
        System.out.println("Running game: "+game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
