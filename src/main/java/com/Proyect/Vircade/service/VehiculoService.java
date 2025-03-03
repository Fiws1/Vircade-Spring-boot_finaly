package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Vehiculo;
import com.Proyect.Vircade.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Page<Vehiculo> listarVehiculos(Pageable pageable) {
        return vehiculoRepository.findAll(pageable);
    }

    public List<Vehiculo> listarTodosLosTiposVehiculos() {
        List<Vehiculo> all = vehiculoRepository.findAll();
        return Collections.unmodifiableList(all);
    }

    public Vehiculo findByVehiculo(int id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + id));
    }

    public Optional<Vehiculo> editarVe(int id) {
        try {
            return vehiculoRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el vehículo por Id: " + e.getMessage(), e);
        }
    }

    public void guardarVe(Vehiculo vehiculo) {
        try {
            vehiculoRepository.save(vehiculo);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el vehículo: " + e.getMessage(), e);
        }
    }

    public void eleminarVe(int id){
        try{
            if (vehiculoRepository.existsById(id)){
                vehiculoRepository.deleteById(id);
            }
            else {
                throw new RuntimeException("El vehículo con ID" + id + "no existe.");
            }
        }catch (Exception e){
            throw new RuntimeException("Error al Eliminar el vehículo por Id: " + e.getMessage(), e);
        }
    }
}
