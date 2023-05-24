package com.example.forDemo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/sample")
    public String sample(){
        return "This is my example return";
    }
}

