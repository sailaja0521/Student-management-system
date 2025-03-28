package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // This method will return the home page (index.jsp)
    @GetMapping("/")
    public String showHomePage() {
        return "index";  // This should map to index.jsp
    }
}
