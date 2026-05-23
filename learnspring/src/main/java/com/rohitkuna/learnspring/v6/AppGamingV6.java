package com.rohitkuna.learnspring.v6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rohitkuna.learnspring.v6.game.Game;
import com.rohitkuna.learnspring.v6.game.GameRunner;
import com.rohitkuna.learnspring.v6.game.MarioGame;

@Configuration
@ComponentScan("com.rohitkuna.learningspring.v6.game") // necessary as Spring doesn't know where to find Game 
// though it's annotated with @Component, we need to mention the package where to find it
public class AppGamingV6 {

    public static void main(String[] args){
        try (var context = new AnnotationConfigApplicationContext(AppGamingV6.class)){

            context.getBean(Game.class).up();

            context.getBean(GameRunner.class).run(); 
            // when we do get context, we are basically getting an instance and working with it

            // Game and GameRunner are now spring beans and we are picking them from Spring Context

        }
    }
}
