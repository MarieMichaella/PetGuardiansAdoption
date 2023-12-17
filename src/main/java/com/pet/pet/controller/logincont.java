package com.pet.pet.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class logincont {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Assuming you have a Thymeleaf template named "login.html"
    }
}
