package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.Usuario;
import com.Proyect.Vircade.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/asesor")
    public String asesores() {
        return "view/asesor/asesor";
    }

    @GetMapping("/logout")
    public String logout(@NotNull HttpServletRequest request, HttpServletResponse response) {
        // Invalidar la sesión actual
        request.getSession().invalidate();
        // Redirigir al usuario a la página de login o inicio
        return "redirect:/login";
    }

    @GetMapping("/recuperacion")
    public String recuperacion(Model model){
        return "recuperacion";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    // Muestra la página de registro
    @GetMapping("/registro/index")
    public String mostrarFormularioRegistro(@NotNull Model model) {
        model.addAttribute("usuario", new Usuario()); // Asegúrate de tener una clase Usuario
        return "registro"; // Retorna el nombre del archivo HTML sin la extensión
    }

    @GetMapping("/pdf")
    public String pdf(Model model){
        return "pdf";
    }
}