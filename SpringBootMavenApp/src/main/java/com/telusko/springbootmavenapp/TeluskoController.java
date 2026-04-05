package com.telusko.springbootmavenapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeluskoController {

    @GetMapping("/greet")
    public String greet(Model model) {
        model.addAttribute("wish", "Good Evening!");
        return "greet";
    }
}
