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

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNomvehiculo() {
        return nomvehiculo;
    }

    public void setNomvehiculo(String nomvehiculo) {
        this.nomvehiculo = nomvehiculo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public Combustible getCombustibleVehiculo() {
        return combustibleVehiculo;
    }

    public void setCombustibleVehiculo(Combustible combustibleVehiculo) {
        this.combustibleVehiculo = combustibleVehiculo;
    }

    public Tipo_Vehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Tipo_Vehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public String getPrecioFormateado() {
        return precioFormateado;
    }

    public void setPrecioFormateado(String precioFormateado) {
        this.precioFormateado = precioFormateado;
    }
}
