package com.travis.azure.controller;

import com.travis.azure.model.Greeting;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
@Api(value = "Greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting sayDefaultMessage(@RequestParam(value="name", defaultValue="Travis") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}