package com.example.springtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    @GetMapping("/")
    public String home(){
        return "Welcome to Champions League";
    }

    @GetMapping("/semifinals")
    public String semifinals() {
        return  "Semifinals: Bayern vs Real, Dortmund vs PSG";
    }

    @GetMapping("/final")
    public String finalMatch() {
        return  "Final: Dortmund vs Real";
    }
}
