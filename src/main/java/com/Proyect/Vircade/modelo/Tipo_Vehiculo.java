package com.Proyect.Vircade.modelo;

import lombok.*;
import jakarta.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_Vehiculos")
public class Tipo_Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_tipo_vehiculo", nullable = false)
    private int id;

    @Column(name = "tipo_vehiculo", nullable = false, length = 20)
    private String tipovehiculo;

}