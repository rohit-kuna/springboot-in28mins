package com.rohitkuna.dependencyinjection.v0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
@ComponentScan // no need to mention the package name here, composcan auto scans the current package
public class SimpleSpringApp {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(SimpleSpringApp.class)) {
            // let's see what all beans are getting created
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            // This prints simpleSpringApp also as a bean because it is annotated with @Configuration -> which makes it eligible for bean creation 
            // and @ComponentScan -> so it is also a candidate for component scanning
        }
    }
}
