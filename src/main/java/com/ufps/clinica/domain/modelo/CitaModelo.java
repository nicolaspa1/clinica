package com.ufps.clinica.domain.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaModelo {
    private Long idCita;
    private LocalDateTime fechaCita;
    private MedicoModelo medicoModelo;
    private PacienteModelo pacienteModelo;


}
