package com.Proyect.Vircade.repository;
import com.Proyect.Vircade.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    List<Usuario> findByRol_idRol(int id);
    Optional<Usuario> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
}
