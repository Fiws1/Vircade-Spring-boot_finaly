package com.Proyect.Vircade.controller;

import com.Proyect.Vircade.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/descargar-reporte")
    public ResponseEntity<byte[]> descargarReporte() {
        byte[] pdf = reporteService.generarReporte();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_asesores.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}