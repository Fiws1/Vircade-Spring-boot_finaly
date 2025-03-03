package com.Proyect.Vircade.modelo;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asesores")
public class Asesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Asesor", nullable = false)
    private int idAsesor;

    @NotBlank
    @Column(name = "p_nom_asesor", nullable = false, length = 20)
    private String pNomAsesor;

    @Column(name = "s_nom_asesor", length = 20)
    private String sNomAsesor;

    @NotBlank
    @Column(name = "p_ape_asesor", nullable = false, length = 20)
    private String pApeAsesor;

    @Column(name = "s_ape_asesor", length = 20)
    private String sApeAsesor;

    @Column(name = "Correo_asesor", nullable = false, length = 100)
    private String correoAsesor;

    @Column(name = "Telefono_asesor", nullable = false)
    private String telefonoAsesor;

    @OneToMany(mappedBy = "asesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> cita;

    @ManyToOne
    @JoinColumn(name = "Concesionario_Asig", nullable = false)
    private Concesionario concesionarioAsig;

    @Override
    public String toString() {
        return "Asesor{" +
                "idAsesor=" + idAsesor +
                ", correoAsesor='" + correoAsesor + '\'' +
                '}';
    }
}
