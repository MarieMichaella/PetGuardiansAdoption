package com.pet.pet.controller;

import com.pet.pet.model.User1;
import com.pet.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
//    private final UserService userService;
//
//    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String processLogin(@RequestParam String username, @RequestParam String password) {
//        // Implement logic to check if the user exists and the password is correct
//        User1 user = userService.findByUsername(username);
//
//        if (user != null && password.equals(user.getPassword())) {
//            // Successful login, you can redirect to a secure page
//            return "redirect:/Dashboard";
//        } else {
//            // Failed login, you can add an error message
//            return "redirect:/login?error";
//        }
//    }
}

