package com.pet.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail, String subject, String name, String contactNumber, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("mariemichaellarug1@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);

        String emailBody = String.format("Name: %s%nContact Number: %s%nMessage: %s", name, contactNumber, message);
        mailMessage.setText(emailBody);

        mailSender.send(mailMessage);

        System.out.println("Mail Sent...");
    }


    public void sendEmail(String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mariemichaellarug1@gmail.com");
        message.setTo("mariemichaellarug1@gmail.com");
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
