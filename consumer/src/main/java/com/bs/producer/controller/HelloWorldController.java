package com.bs.producer.controller;

import com.bs.producer.hello.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloWorldController {
    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping("helloWorld")
    public String helloWorld(String name) {
        name = Optional.ofNullable(name).orElse("noName");
        return helloWorldService.helloWorld(name);
    }

}
