package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.Concesionario;
import com.Proyect.Vircade.modelo.Disponibilidad;
import com.Proyect.Vircade.service.ConcesionarioService;
import com.Proyect.Vircade.service.DisponibilidadService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class ConcesionarioController {

    @Autowired
    private ConcesionarioService concesionarioService;

    @Autowired
    private DisponibilidadService disponibilidadService;

    @GetMapping("/Concesionarios")
    public String listarConcesionarios(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int size, @NotNull Model modelo) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Concesionario> paginaConcesionarios = concesionarioService.ListarConce(pageable);

        Concesionario concesionario = new Concesionario();
        List<Disponibilidad> lidispo = disponibilidadService.ListarDisponibilidad();
        modelo.addAttribute("lidispo", lidispo);
        modelo.addAttribute("Concesionario",concesionario);
        modelo.addAttribute("i", "Concesionarios");

        modelo.addAttribute("Concesionarios", paginaConcesionarios.getContent());
        modelo.addAttribute("currentPage", page);
        modelo.addAttribute("totalPages", paginaConcesionarios.getTotalPages());

        return "view/Concesionario/Concesionario"; // nos retorna al archivo estudiantes
    }

    @PostMapping("/Concesionariosave")
    public String guardarConcesionarios(Concesionario Concesionario, @NotNull Model modelo) {

        List<Disponibilidad> lidispo = disponibilidadService.ListarDisponibilidad();
        modelo.addAttribute("lidispo",lidispo);
        modelo.addAttribute("Concesionario",Concesionario);
        modelo.addAttribute("i", "Concesionarios");

        concesionarioService.guardarConce(Concesionario);
        log.info("Concesionario guardado con exito!");
        return "redirect:/Concesionarios";
    }

    @GetMapping("/Concesionariosedit/{id}")
    public String actualizarConcesionarios(@PathVariable("id") int id, @NotNull Model modelo) {
        Concesionario Concesionario = concesionarioService.findByConcesionario(id);
        List<Disponibilidad> lidispo = disponibilidadService.ListarDisponibilidad();
        modelo.addAttribute("lidispo",lidispo);
        modelo.addAttribute("Concesionario",Concesionario);
        modelo.addAttribute("i", "Concesionarios");
        log.info("Concesionario modificada con exito!");
        return "view/Concesionario/modificar";
    }

    @DeleteMapping("/Concesionariosde/{id}")
    public String eliminarConcesionarios(@PathVariable("id") int id) {
        concesionarioService.eleminarConce(id);
        log.info("Concesionario Eliminado con exito!");
        return "redirect:/Concesionarios";
    }
}
