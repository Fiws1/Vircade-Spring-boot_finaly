package com.Proyect.Vircade.modelo;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Vehiculo",nullable = false)
    private int idVehiculo;

    @Column(name = "Vehiculo", nullable = false, length = 20)
    private String nomvehiculo;

    @Column(name = "Linea", nullable = false, length = 20)
    private String linea;

    @Column(name = "cilindraje", nullable = false, length = 10)
    private String cilindraje;

    @Column(name = "Color", nullable = false, length = 10)
    private String color;

    @Column(name = "Precio", nullable = false)
    private int precio;

    @Column(name = "Imagen", nullable = false)
    private String imagen;

    @Column(name = "Modelo_vehiculo", nullable = false, length = 40)
    private String modeloVehiculo;

    @Column(name = "Marca_vehiculo", nullable = false, length = 20)
    private String marcaVehiculo;

    @ManyToOne
    @JoinColumn(name = "Combustible_vehiculo", nullable = false)
    private Combustible combustibleVehiculo;

    @ManyToOne
    @JoinColumn(name = "Tipo_vehiculo", nullable = false)
    private Tipo_Vehiculo tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "concesionario", nullable = false)
    private Concesionario concesionario;

    @Column(name = "precioFormateado", nullable = true)
    private String precioFormateado;

}
