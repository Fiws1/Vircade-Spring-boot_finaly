package com.Proyect.Vircade.repository;

import com.Proyect.Vircade.modelo.Combustible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombustibleRepository extends JpaRepository<Combustible,Integer> {
}
