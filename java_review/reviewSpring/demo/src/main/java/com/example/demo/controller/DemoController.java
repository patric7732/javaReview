package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hi")
    public String hi() {
        return  "hi, String boot.";

    }

    @GetMapping("/player")
    public String Hojirund() {
        int arr[] = new int[];

        for (int i = 0; i<arr.length; i++){
            System.out.println("hello ");
        }

        return  "hi, i'm manchester united attaker !HOJIRUND!";
    }
}
