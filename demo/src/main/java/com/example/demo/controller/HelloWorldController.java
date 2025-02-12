package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    private final static String PATH = "/";
    @RequestMapping(PATH)
    public String hello() {
        return "Hello world!";
    }
}
