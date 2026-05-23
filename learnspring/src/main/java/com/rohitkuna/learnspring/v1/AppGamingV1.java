package com.rohitkuna.learnspring.v1;

import com.rohitkuna.learnspring.v1.game.GameRunner;
import com.rohitkuna.learnspring.v1.game.MarioGame;

public class AppGamingV1 {
    public static void main(String[] args){
        MarioGame game = new MarioGame(); // this line needs to be changed to change game
        GameRunner gameRunner = new GameRunner(game); // even coinstructor is being passed MarioGame needs to be changed to PacmanGame
        gameRunner.run(); // to start
    }
}
