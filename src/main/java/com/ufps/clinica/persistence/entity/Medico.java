package com.ufps.clinica.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @Column(name = "id_medico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;
    @Column(name = "nombre_medico")
    private String nombre;
    @Column(name = "apellido_medico")
    private String apellido;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    private Especialidad especialidad;
}
