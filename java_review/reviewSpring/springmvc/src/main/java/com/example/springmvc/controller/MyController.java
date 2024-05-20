package com.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/home")
    public String name(){
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(){
        return "a";
    }

    @GetMapping("/con")
    public String contact(){
        return "contact";
    }

    @ResponseBody // 입력 받은 것이 데이터라고 보는 것임
    @GetMapping("rest")
    public String rest(){
        return "restbody test";
    }

//    @GetMapping("greeting")
//    public String greet(String name, int age, HttpServletRequest request){ // model은 mvc 패턴중의 모델,
//        // http://localhost:8888/greeting?name=patric
//        // ?name=patric&age=20 쿼리 문자열, name이 키고 value가 patric
//        System.out.println(name);
//        System.out.println(age);
//
//        System.out.println("requset:::"+request.getParameter("name"));
//        System.out.println("requset:::"+request.getParameter("age"));
//
//        return "greeting";
//    }
    @GetMapping("greeting")
    public String greet(String name, int age, ModelAndView modelAndView){ // model은 mvc 패턴중의 모델,
        // http://localhost:8888/greeting?name=patric
        // ?name=patric&age=20 쿼리 문자열, name이 키고 value가 patric
        System.out.println(name);

        modelAndView.addObject("name", name);
        modelAndView.setViewName("greeting");

        return "greeting";
    }

}

