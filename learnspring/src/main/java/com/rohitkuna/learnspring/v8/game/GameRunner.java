package com.rohitkuna.learnspring.v8.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private Game game;

    @Autowired
    public GameRunner(Game game){
        this.game=game;
    }
    // In case of contructor dependency injection the @Autowired is optional
    // as from 4+ constructor injection is considred automatically

    public void run(){
        System.out.println("Running game: "+game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
