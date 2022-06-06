package com.ufps.clinica.persistence.mapper;

import com.ufps.clinica.domain.modelo.EspecialidadModelo;
import com.ufps.clinica.persistence.entity.Especialidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspecialidadMapeador {
    EspecialidadModelo convertirEspecialidadModelo(Especialidad especialidad);

    @InheritInverseConfiguration
    Especialidad convertirEspecialidad(EspecialidadModelo especialidadModelo);

}
