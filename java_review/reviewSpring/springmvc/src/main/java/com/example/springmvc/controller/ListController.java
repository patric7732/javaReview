package com.example.springmvc.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
    @GetMapping("/list")
    public String showList(Model model){
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");

        model.addAttribute("items", items);
        return "list";
    }
}
