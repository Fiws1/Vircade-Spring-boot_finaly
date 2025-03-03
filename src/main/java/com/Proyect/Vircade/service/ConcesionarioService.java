package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Concesionario;
import com.Proyect.Vircade.repository.ConcesionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcesionarioService {
    @Autowired
    private final ConcesionarioRepository concesionarioRepository;

    public ConcesionarioService(ConcesionarioRepository concesionarioRepository) {
        this.concesionarioRepository = concesionarioRepository;
    }

    public Page<Concesionario> ListarConce(Pageable pageable) {
        return concesionarioRepository.findAll(pageable);
    }

    public List<Concesionario> ListarConce() {
        try {
            return concesionarioRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los Concesionarios: " + e.getMessage(), e);
        }
    }

    public Concesionario findByConcesionario(int id) {
        return concesionarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Error encontrando Concesionario: " + id));
    }

    public Optional<Concesionario> editarConce(int id) {
        try {
            return concesionarioRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el Concesionario: " + e.getMessage(), e);
        }
    }

    public void guardarConce(Concesionario concesionario) {
        try {
            concesionarioRepository.save(concesionario);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el Concesionario: " + e.getMessage(), e);
        }
    }

    public void eleminarConce(int id){
        try{
            if (concesionarioRepository.existsById(id)){
                concesionarioRepository.deleteById(id);
            }
            else {
                throw new RuntimeException("El Concesionario con ID" + id + "no existe.");
            }
        }catch (Exception e){
            throw new RuntimeException("Error al Eliminar el Concesionario: " + e.getMessage(), e);
        }
    }
}
