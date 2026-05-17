package com.rohitkuna.learningspring.v4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rohitkuna.learningspring.v4.game.GameRunner;
import com.rohitkuna.learningspring.v4.game.MarioGame;
import com.rohitkuna.learningspring.v4.game.Game;

@Configuration
public class AppGamingV4 {

    @Bean
    public Game gameBean(){
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunnerBean(Game gameBean){
        return new GameRunner(gameBean);
    }

    public static void main(String[] args){
        try (var context = new AnnotationConfigApplicationContext(AppGamingV4.class)){

            context.getBean(Game.class).up();

            context.getBean(GameRunner.class).run(); 
            // when we do get context, we are basically getting an instance and working with it

            // Game and GameRunner are now spring beans and we are picking them from Spring Context

            // There's no need of separate Config class can be defined in the same one

            // next we'll see how to let spring manage beans
        }
    }
}
