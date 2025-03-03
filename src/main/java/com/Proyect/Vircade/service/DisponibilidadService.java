package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Disponibilidad;
import com.Proyect.Vircade.repository.DisponibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadService {

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    public List<Disponibilidad> ListarDisponibilidad() {
        try {
            return disponibilidadRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar las Disponibilidades: " + e.getMessage(), e);
        }
    }
}
