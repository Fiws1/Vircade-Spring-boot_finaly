package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.Usuario;
import com.Proyect.Vircade.service.UsuarioService;
import com.Proyect.Vircade.service.VehiculoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/admin/dashboard")
    public String showDashboardAdmin(@NotNull Model model, @NotNull Authentication authentication) {
        // Obtener la información del usuario
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String correo = userDetails.getUsername();
        Usuario usuario = usuarioService.findByEmail(correo);
        model.addAttribute("usuario", usuario);
        // Obtener la información del vehículo si se proporciona un idVehiculo
        return "admin/dashboard"; // Plantilla específica para administradores
    }

    @GetMapping("/cliente/dashboard")
    public String showDashboardCliente(@NotNull Model model, @NotNull Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String correo = userDetails.getUsername();
        Usuario usuario = usuarioService.findByEmail(correo);
        model.addAttribute("usuario", usuario);
        return "cliente/dashboard"; // Plantilla específica para clientes
    }

    @GetMapping("/asesor/dashboard")
    public String showDashboardAsesor(@NotNull Model model, @NotNull Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String correo = userDetails.getUsername();
        Usuario usuario = usuarioService.findByEmail(correo);
        model.addAttribute("usuario", usuario);
        return "asesor/dashboard"; // Plantilla específica para asesores
    }

    @RequestMapping("/home")
    public String redireccionPorRol(@NotNull Authentication auth) {
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/dashboard";
        } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_CLIENTE"))) {
            return "redirect:/cliente/dashboard";
        } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ASESOR"))) {
            return "redirect:/asesor/dashboard";
        }
        return "redirect:/login";
    }
}
