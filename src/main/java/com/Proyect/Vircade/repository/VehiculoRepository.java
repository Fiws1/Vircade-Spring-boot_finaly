package com.Proyect.Vircade.repository;

import com.Proyect.Vircade.modelo.Vehiculo;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    @NotNull Optional<Vehiculo> findById(int id);
}
