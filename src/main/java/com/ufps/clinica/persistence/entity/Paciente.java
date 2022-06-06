package com.ufps.clinica.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    @Column(name = "nombre_paciente")
    private String nombre;
    @Column(name = "apellido_paciente")
    private String apellido;
    @Column(name = "documento_paciente")
    private String documento;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita", referencedColumnName = "id_cita")
    private Cita cita;
}
