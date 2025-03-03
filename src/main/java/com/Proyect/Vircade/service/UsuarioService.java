package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Rol;
import com.Proyect.Vircade.modelo.Usuario;
import com.Proyect.Vircade.repository.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> listClientes() {
        try {
            return usuarioRepository.findByRol_idRol(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void registrarUsuario(@NotNull Usuario usuario) {
        Rol rol = new Rol();
        rol.setIdRol(2);
        usuario.setContrasenaUsu(passwordEncoder.encode(usuario.getContrasenaUsu()));
        usuario.setRol(rol);
        usuarioRepository.save(usuario);
    }

    public boolean existeCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByCorreo(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + email));
    }

    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public List<Usuario> listusu() {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los Concesionarios: " + e.getMessage(), e);
        }
    }
}