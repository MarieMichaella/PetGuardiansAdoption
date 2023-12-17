package com.pet.pet.controller;


import com.pet.pet.dto.AuthenticationRequest;
import com.pet.pet.service.jwt.UserDetailsServiceImpl;
import com.pet.pet.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

//    @GetMapping("/login")
//    public String showRegistrationForm() {
//        return "login";
//    }
//    @PostMapping("/authentication")
//    public String createAuthenticationToken(@ModelAttribute AuthenticationRequest authenticationRequest, Model model, HttpServletResponse response) throws BadCredentialsException, DisabledException, IOException {
//        try {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
//            String jwt = jwtUtil.generateToken(userDetails.getUsername());
//            model.addAttribute("token", jwt);
//            return "allPets"; // Assuming you have a success.html template
//        } catch (BadCredentialsException e) {
//            model.addAttribute("error", "Incorrect Username or Password");
//            return "error"; // Return to the login form with an error message
//        } catch (DisabledException disabledException) {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not created. Register User First");
//            return "error"; // Return to the login form with an error message
//        }
//    }
}
