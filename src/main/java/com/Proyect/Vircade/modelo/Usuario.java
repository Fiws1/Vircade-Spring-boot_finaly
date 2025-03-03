package com.Proyect.Vircade.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Email
    @Column(name = "Correo", nullable = false, unique = true, length = 100)
    private String correo;

    @NotBlank
    @NotEmpty(message = "El campo contraseña no puede estar vacío")
    @Column(name = "Contrasena_Usu", nullable = false)
    private String contrasenaUsu;

    @Size(max = 50)
    @NotBlank
    @NotEmpty(message = "El campo primer nombre no puede estar vacío")
    @Column(name = "Primer_Nombre", nullable = false)
    private String primerNombre;

    @Size(max = 50)
    @Column(name = "Segundo_Nombre")
    private String segundoNombre;

    @Size(max = 50)
    @NotBlank
    @NotEmpty(message = "El campo primer apellido no puede estar vacío")
    @Column(name = "Primer_Apellido", nullable = false)
    private String primerApellido;

    @Size(max = 50)
    @Column(name = "Segundo_Apellido")
    private String segundoApellido;

    @Size(max = 15)
    @NotBlank
    @NotEmpty(message = "El campo numero de telefono no puede estar vacío")
    @Column(name = "Numero_telefono")
    private String numeroTelefono;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenaUsu() {
        return contrasenaUsu;
    }

    public void setContrasenaUsu(String contrasenaUsu) {
        this.contrasenaUsu = contrasenaUsu;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}