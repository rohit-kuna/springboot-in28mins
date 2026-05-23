package com.rohitkuna.learnspring.v1.game;

public class GameRunner {
    MarioGame game; 

    public GameRunner(MarioGame game){
        this.game=game;
    }

    // PacmanGame game;
    // public GameRunner(PacmanGame game){
    //     this.game=game;
    // }

    public void run() {
        System.out.println("running game "+game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
