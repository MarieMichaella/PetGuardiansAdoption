package com.pet.pet.controller;


import com.pet.pet.dto.SignupRequest;
import com.pet.pet.dto.UserDTO;
import com.pet.pet.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Signupcontroller {

    @Autowired
    private AuthService authService;

    @GetMapping("/registering")
    public String showRegistrationForm() {
        return "register";
    }

//    @PostMapping("/registergood")
//    public String createUser(@ModelAttribute SignupRequest signupRequest, Model model) {
//        UserDTO createdUser = authService.createUser(signupRequest);
//        if (createdUser == null) {
//            model.addAttribute("error", "User is not created, try again later");
//            return "error"; // Return to the registration form with an error message
//        }
//
//        // Optionally, you can add a success message to the model and show it on a different page
//        model.addAttribute("successMessage", "User created successfully!");
//        return "allPets"; // Assuming you have a success.html template
//    }
}
