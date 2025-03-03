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
}
