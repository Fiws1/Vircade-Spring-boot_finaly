package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Asesor;
import com.Proyect.Vircade.repository.AsesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AsesorService {

    @Autowired
    private AsesorRepository asesorRepository;

    @Transactional(readOnly = true)
    public List<Asesor> ListarAs() {
        try {
            return asesorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los Asesores: " + e.getMessage(), e);
        }
    }

    public List<Asesor> listarTodosLosAsesores() {
        List<Asesor> all = asesorRepository.findAll();
        return Collections.unmodifiableList(all);
    }

    @Transactional(readOnly = true)
    public Page<Asesor> ListarAs(Pageable pageable) {
        return asesorRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Asesor> editarAs(int id) {
        try {
            return asesorRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el Asesor por Id: " + e.getMessage(), e);
        }
    }

    public void guardarAs(Asesor asesor) {
        try {
            asesorRepository.save(asesor);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el Asesor: " + e.getMessage(), e);
        }
    }

    public void eleminarAs(int id){
        try{
            if (asesorRepository.existsById(id)){
                asesorRepository.deleteById(id);
            }
            else {
                throw new RuntimeException("El Asesor con ID" + id + "no existe.");
            }
        }catch (Exception e){
            throw new RuntimeException("Error al Eliminar el Asesor por Id: " + e.getMessage(), e);
        }
    }
}
