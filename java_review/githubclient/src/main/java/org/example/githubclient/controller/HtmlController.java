package org.example.githubclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping("/repos")
    public String repos() {
        return "repos";
    }
}

