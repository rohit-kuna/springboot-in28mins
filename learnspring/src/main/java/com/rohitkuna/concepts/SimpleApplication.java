package com.rohitkuna.concepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Arrays;

@Configuration
@ComponentScan // no need to mention the package name here, composcan auto scans the current package
public class SimpleApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(SimpleApplication.class)) {
            // let's see what all beans are getting created
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            
            System.out.println(context.getBean(Business.class)); 
            // now they get printed as @Autowired is used
        }
    }
}

// Component
@Named // Alternative from Jakarta CDI 
class Business {
    
    Dependency1 dependency1;

    Dependency2 dependency2;

    // Setter injection
    // @Autowired
    @Inject // Alternative from Jakarta CDI 
    public void setDependency1(Dependency1 dependency1, Dependency2 dependency2){
        this.dependency1=dependency1;
        this.dependency2=dependency2;
    }

    public String toString(){
        return "Using dependencies: " + dependency1 + " & "+ dependency2;
    }

}

// @Component
@Named
class Dependency1 {

}

// @Component
@Named
class Dependency2 {

}