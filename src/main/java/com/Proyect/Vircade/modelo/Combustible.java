package com.Proyect.Vircade.modelo;

import lombok.*;
import jakarta.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "combustibles")
public class Combustible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_combustible", nullable = false)
    private int idCombustible;

    @Column(name = "Tipo_combustible", nullable = false, length = 20)
    private String tipoCombustible;

}