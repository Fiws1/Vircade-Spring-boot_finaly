package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.*;
import com.Proyect.Vircade.service.AsesorService;
import com.Proyect.Vircade.service.CitaService;
import com.Proyect.Vircade.service.ConcesionarioService;
import com.Proyect.Vircade.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class CitaController {

    @Autowired
    private CitaService servicio;

    @Autowired
    private ConcesionarioService concesionarioService;

    @Autowired
    private AsesorService asesorService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/citas")
    public String listarCitas(@NotNull Model modelo) {
        List<Cita> listadoCitas = servicio.listarTodasCitas();
        Cita Cita = new Cita();

        List<Concesionario> liistaConcesionario = concesionarioService.ListarConce();
        List<Asesor> liistasesor = asesorService.ListarAs();
        List<Usuario> lisus = usuarioService.listusu();
        modelo.addAttribute("lisus", lisus);
        modelo.addAttribute("lisasesor", liistasesor);
        modelo.addAttribute("lisConce",liistaConcesionario);
        modelo.addAttribute("Cita",Cita);
        modelo.addAttribute("i", "Citas");
        modelo.addAttribute("citas", listadoCitas);
        return "view/cita/cita"; // nos retorna al archivo estudiantes
    }

    @PostMapping("/Citasave")
    public String guardarCitas(Cita Cita, @NotNull Model modelo) {

        List<Concesionario> liistaConcesionario = concesionarioService.ListarConce();
        List<Asesor> liistasesor = asesorService.ListarAs();
        List<Usuario> lisus = usuarioService.listClientes();
        modelo.addAttribute("lisus", lisus);
        modelo.addAttribute("lisasesor", liistasesor);
        modelo.addAttribute("lisConce",liistaConcesionario);
        modelo.addAttribute("Cita",Cita);
        servicio.guardarCita(Cita);
        log.info("Cita guardado con exito!");

        return "redirect:/citas";
    }

    @GetMapping("/Citasedit/{id}")
    public String actualizarCitas(@PathVariable("id") int id, @NotNull Model modelo) {
        Cita Cita = servicio.obtenerCitaPorId(id);
        List<Concesionario> listaConcesionario = concesionarioService.ListarConce();
        List<Asesor> listasesor = asesorService.listarTodosLosAsesores();
        List<Usuario> listausuarios = usuarioService.listusu();
        modelo.addAttribute("lisus", listausuarios);
        modelo.addAttribute("lisasesor", listasesor);
        modelo.addAttribute("lisConce",listaConcesionario);
        modelo.addAttribute("Cita",Cita);
        log.info("Cita modificada con exito!");
        return "view/cita/modificar";
    }

    @DeleteMapping("/Citasde/{id}")
    public String eliminarCitas(@PathVariable("id") int id) {
        servicio.eleminarCita(id);
        log.info("Cita Eliminada con exito!");
        return "redirect:/citas";
    }
}