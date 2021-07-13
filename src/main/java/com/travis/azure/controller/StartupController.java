package com.travis.azure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartupController {
    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
