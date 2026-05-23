package com.rohitkuna.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class AppHelloWorld {
    public static void main(String[] args) {

        // ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        try( var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // by @Bean method name
            System.out.println(context.getBean("nameBean"));

            // by custom name provided in @Bean(name="customName")
            System.out.println(context.getBean("customPersonBean"));

            // by Type
            System.out.println(context.getBean(String.class)); // here name

            System.out.println(context.getBean("personBean2"));

            System.out.println(context.getBean("personBean3"));

            // by Type but if there are two same Beans exist use @Primary or @Qualifier
            System.out.println(context.getBean(Address.class));

            // calling Bean which used @Qualifier
            System.out.println(context.getBean("employeeBean"));
        }

    }
}
