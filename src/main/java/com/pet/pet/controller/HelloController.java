package com.pet.pet.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/home")
    public String hello() {
        return "index";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {return "allPets";}

}
