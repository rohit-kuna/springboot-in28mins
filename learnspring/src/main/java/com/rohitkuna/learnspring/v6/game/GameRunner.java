package com.rohitkuna.learnspring.v6.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private Game game;

    public GameRunner(@Qualifier("PacmanGameQualifier") Game game){
        this.game=game;
    }

    public void run(){
        System.out.println("Running game: "+game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
