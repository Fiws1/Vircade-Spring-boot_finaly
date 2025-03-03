package com.Proyect.Vircade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/Automovil")
    public String showAutomovil(){
        return "page/Automovil";
    }

    @GetMapping("/Camioneta")
    public String showCamioneta(){
        return "page/Camioneta";
    }

    @GetMapping("/carro_1_chevrolet")
    public String showcarro_1_chevrolet(){
        return "page/carro 1 chevrolet";
    }

    @GetMapping("/carro_2_chevrolet")
    public String showcarro_2_chevrolet(){
        return "page/carro 2 chevrolet";
    }

    @GetMapping("/carro_3_chevrolet")
    public String showcarro_3_chevrolet(){
        return "page/carro 3 chevrolet";
    }

    @GetMapping("/Chevrolet")
    public String showChevroletPage() {
        return "page/Chevrolet"; // nombre de la vista Thymeleaf (chevrolet.html)
    }

    // Página de inicio
    @GetMapping("/Inicio")
    public String showHomePage() {
        return "page/inicio"; // nombre de la vista Thymeleaf (inicio.html)
    }

    @GetMapping("/Renault_Alaskan")
    public String showRenaultAlaskanPage() {
        return "page/renault_alaskan"; // nombre de la vista Thymeleaf (renault_alaskan.html)
    }

    // Página de detalles del Renault Logan
    @GetMapping("/Renault_Logan")
    public String showRenaultLoganPage() {
        return "page/Renault Logan"; // nombre de la vista Thymeleaf (renault_logan.html)
    }

    // Página de detalles del Renault Sandero
    @GetMapping("/Renault Sandero")
    public String showRenaultStepwayPage() {
        return "page/Renault Sandero"; // nombre de la vista Thymeleaf (renault_stepway.html)
    }

    @GetMapping("/Renault Stepway")
    public String Renault_Stepway(){
        return "page/Renault Stepway";
    }

    @GetMapping("/Renew_Autostok-Renault")
    public String showRenaultPage() {
        return "page/Renew_Autostok-Renault"; // nombre de la vista Thymeleaf (renew_autostok_renault.html)
    }

    // Página sobre nosotros
    @GetMapping("/Sobre_nosotros")
    public String showAboutPage() {
        return "page/Sobre nosotros"; // nombre de la vista Thymeleaf (sobre_nosotros.html)
    }


    // Página de detalles del Chevrolet Cruze
    @GetMapping("/Chevrolet_Cruze")
    public String showChevroletCruzePage() {
        return "page/chevrolet_cruze"; // nombre de la vista Thymeleaf (chevrolet_cruze.html)
    }
}