package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Combustible;
import com.Proyect.Vircade.repository.CombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombustibleService {
    @Autowired
    private final CombustibleRepository combustibleRepository;

    public CombustibleService(CombustibleRepository combustibleRepository) {
        this.combustibleRepository = combustibleRepository;
    }

    public List<Combustible> ListarCom() {
        try {
            return combustibleRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los Combustible: " + e.getMessage(), e);
        }
    }

    public Optional<Combustible> editarCom(int id) {
        try {
            return combustibleRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la Combustible: " + e.getMessage(), e);
        }
    }

    public void guardarCom(Combustible combustible) {
        try {
            combustibleRepository.save(combustible);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar los Combustible: " + e.getMessage(), e);
        }
    }

    public void eleminarCom(int id){
        try{
            if (combustibleRepository.existsById(id)){
                combustibleRepository.deleteById(id);
            }
            else {
                throw new RuntimeException("El Combustible con ID" + id + "no existe.");
            }
        }catch (Exception e){
            throw new RuntimeException("Error al Eliminar el Combustible: " + e.getMessage(), e);
        }
    }
}
