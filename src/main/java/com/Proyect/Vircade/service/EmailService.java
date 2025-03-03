package com.Proyect.Vircade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendPasswordResetEmail(String to, String token) {
        String subject = "Restablecer contraseña";
        String resetUrl = "http://localhost:8080/reset-password?token=" + token;

        Context context = new Context();
        context.setVariable("resetUrl", resetUrl);
        String body = templateEngine.process("/reset-password-email", context);

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(body);
        emailSender.send(email);
    }
}