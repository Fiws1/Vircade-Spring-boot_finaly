package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.service.EmailService;
import com.Proyect.Vircade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PasswordResetController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/recuperar")
    public String recuperarContraseña(@RequestParam String correo, RedirectAttributes redirectAttributes) {
        // Verifica si el correo existe
        if (!usuarioService.existeCorreo(correo)) {
            redirectAttributes.addFlashAttribute("error", "El correo proporcionado no está registrado.");
            return "redirect:/recuperacion"; // Redirige a la página de recuperación
        }

        // Aquí deberías generar un token único para el restablecimiento de la contraseña
        String token = "token-generado"; // Implementa la lógica para generar un token

        // Envía el correo
        emailService.sendPasswordResetEmail(correo, token);

        redirectAttributes.addFlashAttribute("message", "Se ha enviado un correo para restablecer la contraseña.");
        return "redirect:/recuperacion"; // Redirige a la página de recuperación
    }
}