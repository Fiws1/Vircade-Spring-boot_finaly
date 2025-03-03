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
@Table(name = "disponibilidades")
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_dispo", nullable = false)
    private int idDispo;

    @NotBlank
    @Column(name = "Disponibilidad", nullable = false)
    @Enumerated(EnumType.STRING)
    private DisponibilidadEstado disponibilidad;

    public enum DisponibilidadEstado {
        SI, NO
    }

}
