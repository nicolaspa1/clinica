package com.ufps.clinica.domain.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EspecialidadModelo {
    private Long idEspecialidad;
    private String nombre;
    private String descripcion;
}
