package com.bs.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
    @GetMapping("helloWorld")
    public String helloWorld(String name) {
        return "helloWorld to " + name + " !";
    }
}
