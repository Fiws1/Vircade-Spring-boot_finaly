package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.modelo.Asesor;
import com.Proyect.Vircade.service.AsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asesor")
public class AsesorController {

    @Autowired
    private AsesorService asesorService;

    @GetMapping("/allAsesor")
    public ResponseEntity<List<Asesor>> getAllAsesor() {
        List<Asesor> asesors = asesorService.ListarAs();
        return ResponseEntity.ok(asesors);
    }

    @PutMapping("/{idAsesor}")
    public ResponseEntity<Optional<Asesor>> updateAsesor(@PathVariable int idAsesor) {
        Optional<Asesor> asesor = asesorService.editarAs(idAsesor);
        if (asesor.isPresent()) {
            return ResponseEntity.ok(asesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/Asesor")
    public ResponseEntity<Asesor> saveAsesor(@RequestBody Asesor idAsesor) {
        asesorService.guardarAs(idAsesor);
        return ResponseEntity.ok(idAsesor);
    }

    @DeleteMapping("/{idAsesor}")
    public ResponseEntity<Asesor> deleteAsesor(@PathVariable int idAsesor) {
        asesorService.eleminarAs(idAsesor);
        return ResponseEntity.noContent().build(); // Success with no content to return
    }
}
