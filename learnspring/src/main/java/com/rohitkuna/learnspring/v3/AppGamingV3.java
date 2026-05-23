package com.rohitkuna.learnspring.v3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohitkuna.learnspring.v3.game.Game;
import com.rohitkuna.learnspring.v3.game.GameConfig;
import com.rohitkuna.learnspring.v3.game.GameRunner;

public class AppGamingV3 {
    public static void main(String[] args){
        try (var context = new AnnotationConfigApplicationContext(GameConfig.class)){

            context.getBean(Game.class).up();

            context.getBean(GameRunner.class).run(); 
            // when we do get context, we are basically getting an instance and working with it

            // Game and GameRunner are now spring beans and we are picking them from Spring Context

            // But still in this version you might be thinkinhg we are creating objects in Config and then starting, 
            // how to delegate Spring to do that for us
            // see version 4
        }
    }
}
