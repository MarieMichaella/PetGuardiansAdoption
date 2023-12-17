package com.pet.pet.controller;

import com.pet.pet.EmailSenderService;
import com.pet.pet.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdoptionController {

    @Autowired
    private EmailSenderService emailService;

    @GetMapping("/adoption")
    public String showAdoptionEmail() {
        return "adoptionInterest";
    }

    @PostMapping("/send-interest")
    public String sendAdoptionInterest(@RequestParam String name,
                                       @RequestParam String phoneNumber,
                                       @RequestParam String message) {
        String emailContent = "Adoption Interest:\n"
                + "Pet Name: " + name + "\n"
                + "Phone Number: " + phoneNumber + "\n"
                + "Message: " + message;

        emailService.sendEmail("Adoption Interest", emailContent);

        return "redirect:/confirmation";
    }
    @GetMapping("/adoption-form/{name}")
    public String showAdoptionForm(@PathVariable String name, Model model) {
        Pet adoptionInterest = new Pet();
        adoptionInterest.setName(name);
        model.addAttribute("adoptionInterest", adoptionInterest);
        return "adoptionInterest";
    }


    @GetMapping("/confirmation")
    public String showConfirmationPage() {
        return "confirmation";
    }
}
