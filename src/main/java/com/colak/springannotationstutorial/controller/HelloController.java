package com.colak.springannotationstutorial.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final ApplicationContext applicationContext;

    // http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        // It is always better to get a prototype bean from the application context
        OrderProcessor orderProcessor1 = applicationContext.getBean(OrderProcessor.class);
        OrderProcessor orderProcessor2 = applicationContext.getBean(OrderProcessor.class);

        return String.format("first = %s Second = %s",
                Integer.toHexString(orderProcessor1.hashCode()),
                Integer.toHexString(orderProcessor2.hashCode()));
    }

}
