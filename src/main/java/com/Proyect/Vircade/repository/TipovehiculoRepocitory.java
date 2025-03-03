package com.Proyect.Vircade.repository;

import com.Proyect.Vircade.modelo.Tipo_Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipovehiculoRepocitory extends CrudRepository<Tipo_Vehiculo, Integer> {

}
