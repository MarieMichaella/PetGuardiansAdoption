package com.pet.pet.controller;

import com.pet.pet.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.mail.MessagingException;

@Controller
public class EmailController {

    @Autowired
    private EmailSenderService senderService;

    @RequestMapping("/contact")
    public String showForm() {
        return "contact";
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String name,
                            @RequestParam String phone,
                            @RequestParam String message,
                            Model model) throws MessagingException {
        String toEmail = "mariemichaellarug1@gmail.com";
        String subject = "Subject of the email";

        senderService.sendSimpleEmail(toEmail, subject, name, phone, message);

        model.addAttribute("message", "Email sent successfully!");
        return "contact";
    }
}
