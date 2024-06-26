package org.example.securityexam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {

        return "home";
    }
    @GetMapping("/loginForm")
    public String loginForm() {

        return "loginForm";
    }
    @GetMapping("/fail")
    public String fail() {

        return "fail";
    }
    @GetMapping("/success")
    public String success() {

        return "success";
    }
}
