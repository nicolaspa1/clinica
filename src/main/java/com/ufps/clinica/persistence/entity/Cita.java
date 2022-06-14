package com.ufps.clinica.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cita")
public class Cita {
    @Id
    @Column(name = "id_cita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;
    @Column
    private LocalDateTime fechaCita;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    private Medico medico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente",referencedColumnName ="id_paciente")
    private Paciente paciente;


}
