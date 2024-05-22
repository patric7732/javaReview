package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {
    @GetMapping("/start")
    public String startProcess(Model model){
        model.addAttribute("forwardTest", "patric");
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward(){
        return "forwardPage"; // forwardPage는 view 이름임
    }

    @GetMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("redirectTest", "patric");
        return "redirect:/finalDestination";
    }

    @GetMapping("/finalDestination")
    public String finalDestination(){
        return "redirectPage";
    }
}
