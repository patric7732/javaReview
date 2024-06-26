package org.example.securityexam2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    //계정이 user 하나만 존재. -- 계정추가 할 필요가 있을꺼다.
    //인증만되면 어떤 페이지든 갈 수 있다.  -- 권한을 추가할 필요가 있다.

    @GetMapping("/info")
    public String info(){
        return "info";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm Page";
    }
    @GetMapping("/success")
    public String success(){
        return "success";
    }
    @GetMapping("/fail")
    public String fail(){
        return "fail";
    }
}