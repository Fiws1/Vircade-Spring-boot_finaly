package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Tipo_Vehiculo;

import java.util.List;

public interface TipovehiculoServicio {

    public List<Tipo_Vehiculo> listarTodosLosTiposVehiculos();

    public void guardarTiposVehiculos(Tipo_Vehiculo tipoVehiculo);

    public Tipo_Vehiculo obtenerTiposVehiculosPorId(int id);

    public void actualizarTiposVehiculos(Tipo_Vehiculo tipoVehiculo);

    public void eliminarTiposVehiculos(int id);
}