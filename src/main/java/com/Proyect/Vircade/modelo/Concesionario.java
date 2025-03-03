package com.Proyect.Vircade.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "concesionarios")
public class Concesionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Concesionario", nullable = false)
    private int idConcesionario;

    @NotBlank
    @Column(name = "Concesionario", nullable = false, length = 50)
    private String nombreConcesionario;

    @NotBlank
    @Column(name = "Direccion", nullable = false, length = 30)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "Disponibilidades", nullable = false)
    private Disponibilidad disponibilidad;

    public int getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(int idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public String getNombreConcesionario() {
        return nombreConcesionario;
    }

    public void setNombreConcesionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
