package com.rohitkuna.learnspringsecurity.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodosForUser(@PathVariable String username){
        return List.of(new Todo("AWS","Amazon Web Services"));
    }

    @PostMapping("/users/{username}/todos")
    public void updateTodosForUser(@PathVariable String username, @RequestBody Todo todo){
        logger.info(String.format("Added todo: %s - %s", todo.title(), todo.description()));
    }
}

record Todo(String title, String description){}
