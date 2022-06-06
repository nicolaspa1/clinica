package com.ufps.clinica.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @Column(name = "id_especialidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidad;
    @Column(name = "nombre_especialidad", length = 120)
    private String nombre;
    @Column(name = "descripcion_especialidad", length = 500)
    private String descripcion;
}
