package com.ufps.clinica.domain.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteModelo {
    private Long idPaciente;
    private String nombre;
    private String apellido;
    private String documento;
}
