package com.rohitkuna.learningspring.v3.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Bean
    public Game gameBean(){
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunnerBean(Game gameBean){ // making use of existing bean to create a new one
        // also called as mwethod parameter injection, implicit autowiring 
        // as Beans are instances that we pass
        return new GameRunner(gameBean);
    }
}
