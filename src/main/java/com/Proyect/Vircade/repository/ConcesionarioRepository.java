package com.Proyect.Vircade.repository;

import com.Proyect.Vircade.modelo.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcesionarioRepository extends JpaRepository<Concesionario,Integer> {
}
