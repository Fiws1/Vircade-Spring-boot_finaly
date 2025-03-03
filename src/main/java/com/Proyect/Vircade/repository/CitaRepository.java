package com.Proyect.Vircade.repository;

import com.Proyect.Vircade.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByClienteRelacionado_correo(String clienteId);
}
