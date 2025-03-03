package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.service.CombustibleService;
import com.Proyect.Vircade.modelo.Combustible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Combustible")
public class CombustibleController {

    @Autowired
    private CombustibleService combustibleService;

    @GetMapping("/allCombustible")
    public ResponseEntity<List<Combustible>> getAllCombustible() {
        List<Combustible> combustibles = combustibleService.ListarCom();
        return ResponseEntity.ok(combustibles);
    }

    @PutMapping("/{idCombustible}")
    public ResponseEntity<Optional<Combustible>> updateConcesionario(@PathVariable int idCombustible) {
        Optional<Combustible> combustible = combustibleService.editarCom(idCombustible);
        if (combustible.isPresent()) {
            return ResponseEntity.ok(combustible);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/Combustible")
    public ResponseEntity<Combustible> saveCombustible(@RequestBody Combustible idCombustible) {
        combustibleService.guardarCom(idCombustible);
        return ResponseEntity.ok(idCombustible);
    }

    @DeleteMapping("/{idCombustible}")
    public ResponseEntity<Combustible> deleteCombustible(@PathVariable int idCombustible) {
        combustibleService.eleminarCom(idCombustible);
        return ResponseEntity.noContent().build(); // Success with no content to return
    }
}