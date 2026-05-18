package com.rohitkuna.dependencyinjection.v4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan // no need to mention the package name here, composcan auto scans the current package
public class DepInjApplication {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(DepInjApplication.class)) {
            // let's see what all beans are getting created
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            // This prints depInjApplication also as a bean because it is annotated with @Configuration -> which makes it eligible for bean creation 
            // and @ComponentScan -> so it is also a candidate for component scanning

            System.out.println(context.getBean(Business.class)); 
            // now they get printed as @Autowired is used
        }
    }
}

@Component
class Business {
    
    Dependency1 dependency1;

    Dependency2 dependency2;

    // Constructor injection -> 
    // in case of constructor injection we can skip writing Autowired as Spring considers autowiring when using Constructor injection

    // @Autowired
    public Business(Dependency1 dependency1, Dependency2 dependency2){
        super(); // this is added by default by the compiler, we can skip writing it 
        this.dependency1=dependency1;
        this.dependency2=dependency2;
    }

    public String toString(){
        return "Using dependencies: " + dependency1 + " & "+ dependency2;
    }

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}