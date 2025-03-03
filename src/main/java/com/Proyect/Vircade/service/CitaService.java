package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Cita;
import com.Proyect.Vircade.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> listarTodasCitas() {
        List<Cita> all = citaRepository.findAll();
        return Collections.unmodifiableList(all);
    }

    public List<Cita> listarCitasPorCliente(String clienteId) {
        return citaRepository.findByClienteRelacionado_correo(clienteId);
    }

    public List<Cita> ListarCita() {
        try {
            return citaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar las Cita: " + e.getMessage(), e);
        }
    }

    public Cita obtenerCitaPorId(int id) {
        return citaRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Cita no encontrada en el sistema: " + id));
    }

    public Optional<Cita> editarCita(int id) {
        try {
            return citaRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la Cita: " + e.getMessage(), e);
        }
    }

    public void guardarCita(Cita cita) {
        try {
            citaRepository.save(cita);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la Cita: " + e.getMessage(), e);
        }
    }

    public void eleminarCita(int id){
        try{
            if (citaRepository.existsById(id)){
                citaRepository.deleteById(id);
            }
            else {
                throw new RuntimeException("La Cita con ID" + id + "no existe.");
            }
        }catch (Exception e){
            throw new RuntimeException("Error al Eliminar la Cita: " + e.getMessage(), e);
        }
    }
}
