package com.rohitkuna.prepost.v1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class SimpleLauncherApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(SimpleLauncherApplication.class)){
            
            context.getBean(Business.class);
            // Only the dependencies get Autowired
            // but the initialize() doesn't run after it, though the dependencies are ready

        }
    }
}

@Component
class Business {
    private Dependency dependency;

    @Autowired
    public Business(Dependency dependency) {
        this.dependency=dependency;
        System.out.println("Dependencies autowired and ready");
    }

    public void initialize() {
        this.dependency.start();
    }
}

@Component
class Dependency {
    public void start() {
        System.out.println("Dependency started");
    }
}
