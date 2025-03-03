package com.Proyect.Vircade.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Fecha", nullable = false)
    private String fecha;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "Hora", nullable = false)
    private String hora;

    @Column(name = "Tipo_cita", nullable = false, length = 40)
    private String tipoCita;

    @ManyToOne
    @JoinColumn(name = "Asesor", nullable = false)
    private Asesor asesor;

    @ManyToOne
    @JoinColumn(name = "Cliente_relacionado", nullable = false)
    private Usuario clienteRelacionado;

    @ManyToOne
    @JoinColumn(name = "Concesionario_Asig", nullable = false)
    private Concesionario concesionarioAsig;

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", tipoCita='" + tipoCita + '\'' +
                ", asesor=" + (asesor != null ? asesor.getCorreoAsesor() : "null") + // Evitar recursión
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public Usuario getClienteRelacionado() {
        return clienteRelacionado;
    }

    public void setClienteRelacionado(Usuario clienteRelacionado) {
        this.clienteRelacionado = clienteRelacionado;
    }

    public Concesionario getConcesionarioAsig() {
        return concesionarioAsig;
    }

    public void setConcesionarioAsig(Concesionario concesionarioAsig) {
        this.concesionarioAsig = concesionarioAsig;
    }
}
