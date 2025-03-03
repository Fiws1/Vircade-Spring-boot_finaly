package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Tipo_Vehiculo;
import com.Proyect.Vircade.repository.TipovehiculoRepocitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_vehiculoService implements TipovehiculoServicio{

    @Autowired
    private TipovehiculoRepocitory repositorio;

    @Override
    public List<Tipo_Vehiculo> listarTodosLosTiposVehiculos() {
        return (List<Tipo_Vehiculo>) repositorio.findAll();
    }

    @Override
    public void guardarTiposVehiculos(Tipo_Vehiculo tipoVehiculo) {
        repositorio.save(tipoVehiculo);
    }

    @Override
    public Tipo_Vehiculo obtenerTiposVehiculosPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void actualizarTiposVehiculos(Tipo_Vehiculo tipoVehiculo) {
        repositorio.save(tipoVehiculo);
    }

    @Override
    public void eliminarTiposVehiculos(int id) {
        repositorio.deleteById(id);
    }
}
