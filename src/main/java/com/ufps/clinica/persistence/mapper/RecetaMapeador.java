package com.ufps.clinica.persistence.mapper;

import com.ufps.clinica.domain.modelo.RecetaMedicaModelo;
import com.ufps.clinica.persistence.entity.RecetaMedica;
import org.mapstruct.InheritInverseConfiguration;

public interface RecetaMapeador {
    RecetaMedicaModelo convertirRecetaModelo(RecetaMedica recetaMedica);

    @InheritInverseConfiguration
    RecetaMedicaModelo convertirReceta(RecetaMedicaModelo recetaMedicaModelo);
}
