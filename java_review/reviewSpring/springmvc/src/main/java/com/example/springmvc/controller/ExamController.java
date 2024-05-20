package com.example.springmvc.controller;

import com.example.springmvc.domain.Item;
import com.example.springmvc.domain.Product;
import com.example.springmvc.domain.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcomeMessage", "Welcome to our awesome website!");
        List<Item> items = Arrays.asList(
                new Item("Apple", 1.25),
                new Item("Banana", 0.75),
                new Item("Orange", 0.50)
        );
        model.addAttribute("items", items);
        return "welcome";

    }
    @GetMapping("/product")
    public String product(Model model) {
        List<Product> products = Arrays.asList(
                new Product(1, "Apple", 1.25),
                new Product(2, "Banana", 0.75),
                new Product(3, "Orange", 0.50)
        );
        model.addAttribute("products", products);
        return "product";

    }

    @GetMapping("/example")
    public String showExam(Model model){
        model.addAttribute("username", "patric");
        model.addAttribute("isAdmin", false);
        model.addAttribute("languages", new String[]{"English", "Spanish", "German"});
        return "exam";
    }

    @GetMapping("/users")
    public String showUsers(Model model){
        List<User> users = Arrays.asList(
                new User("벨링엄", "CAM"),
                new User("호일룬", "ST"),
                new User("라이스", "CM")
        );
        model.addAttribute("users", users);
        return "users";
    }
}
