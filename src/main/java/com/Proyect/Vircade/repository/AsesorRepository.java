package com.Proyect.Vircade.repository;

import com.Proyect.Vircade.modelo.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Integer> {
}
