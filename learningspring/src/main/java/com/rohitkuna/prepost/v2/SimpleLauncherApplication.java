package com.rohitkuna.prepost.v2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
@ComponentScan
public class SimpleLauncherApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(SimpleLauncherApplication.class)){
            // context.getBean(Business.class);
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
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

    @PostConstruct // if you want to run some initializations as soon as the dependencies are wired in, use PostConstruct
    public void initialize() {
        this.dependency.start();
    }

    @PreDestroy // if you want to do cleanup, before the Buisness bean is removed from the context, use PreDestroy
    public void cleanup(){ // just before the Business bean is removed from the context cleanup is called
        System.out.println("Database connections closed");
    }
}

@Component
class Dependency {
    public void start() {
        System.out.println("Database connections acquired");
    }
}
