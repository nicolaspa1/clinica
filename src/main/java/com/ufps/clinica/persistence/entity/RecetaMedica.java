package com.ufps.clinica.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "receta")
public class RecetaMedica {
    @Id
    @Column(name = "id_receta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita", referencedColumnName = "id_cita")
    private Cita cita;
}
