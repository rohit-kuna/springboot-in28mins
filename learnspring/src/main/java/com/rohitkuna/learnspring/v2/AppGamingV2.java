package com.rohitkuna.learnspring.v2;

import com.rohitkuna.learnspring.v2.game.Game;
import com.rohitkuna.learnspring.v2.game.GameRunner;
import com.rohitkuna.learnspring.v2.game.MarioGame;

public class AppGamingV2 {
    public static void main(String[] args){
        Game game = new MarioGame(); // object creation - // only this line needs to be changed for game change
        GameRunner gameRunner = new GameRunner(game); // Object Creation 
        // + Wiring of dependencies
        // i.e. injection of dependency 
        // as Game is dependency of GameRunner
        gameRunner.run();
    }
}
