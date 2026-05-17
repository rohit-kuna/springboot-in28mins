package com.rohitkuna.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {
    
    @Bean
    public String nameBean(){
        return "Ross";
    }

    @Bean
    public int ageBean(){
        return 19;
    }

    @Bean(name="customPersonBean")
    public Person personBean(){
        return new Person("Joey", 29);
    }

    @Bean
    @Primary // used for prioritizing incase when fetched bean from type
    public Address addressBean1(){
        return new Address("Baker Str", "London");
    }

    @Bean
    public Address addressBean2(){
        return new Address("Newyork Str", "Newyork");
    }

    // Reusing Beans to create new 
    // passing method calls
    @Bean
    public Person personBean2() {
        return new Person(nameBean(), ageBean());
    }

    // passing as params
    // also called as mwethod parameter injection, implicit autowiring as beans are instances that we pass
    @Bean
    public Person personBean3(String nameBean, int ageBean) { // pass names of methods (in case of custom name include the custom name)
        return new Person(nameBean, ageBean);
    }

    @Bean
    @Qualifier("addressqualifier") // Qualifier declaration
    public Address addressBean3(){
        return new Address("LBS Marg","Karjur");
    }
    // Usage of Qualifier
    @Bean
    public Employee employeeBean(String nameBean, int ageBean, @Qualifier("addressqualifier") Address addressBean){
        return new Employee(nameBean, ageBean, addressBean);
    }

}

record Person(String name, int age){}

record Address(String firstLine, String city){}

record Employee(String name, int age, Address address){}