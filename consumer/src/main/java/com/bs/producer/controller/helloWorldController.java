package com.bs.producer.controller;

import com.bs.producer.hello.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping("helloWorld")
    public String helloWorld(){
        return helloWorldService.helloWorld("bisheng");
    }
}
