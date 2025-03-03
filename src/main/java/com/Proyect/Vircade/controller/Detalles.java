package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.Asesor;
import com.Proyect.Vircade.modelo.Cita;
import com.Proyect.Vircade.service.AsesorService;
import com.Proyect.Vircade.service.CitaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class Detalles {

    @Autowired
    private CitaService citaService;

    @Autowired
    private AsesorService asesorService;

    @GetMapping("/detalleAsesor")
    public String detalle_Asesores(@NotNull Model modelo) {
        List<Asesor> asesores = asesorService.listarTodosLosAsesores();
        modelo.addAttribute("detalle", asesores); // Cambia "detalle" por el nombre que usarás en la vista
        modelo.addAttribute("titulo", "Asesores");

        // Verificar si la lista de asesores está vacía
        if (asesores.isEmpty()) {
            modelo.addAttribute("mensajeError", "No hay asesores disponibles.");
        }
        return "view/comunicate/detalleAsesor";
    }

    @GetMapping("/citasCliente/{correo}")
    public String citasCliente(@PathVariable String correo, @NotNull Model modelo) {
        List<Cita> citas = citaService.listarCitasPorCliente(correo);
        modelo.addAttribute("citas", citas);
        modelo.addAttribute("titulo", "Citas del Cliente");

        if (citas.isEmpty()) {
            modelo.addAttribute("mensajeError", "No tienes citas disponibles.");
        }

        return "view/cita/detalleCitas"; // Nombre del HTML donde se mostrarán las citas
    }

}