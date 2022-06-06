package com.ufps.clinica.persistence.mapper;

import com.ufps.clinica.domain.modelo.CitaModelo;
import com.ufps.clinica.persistence.entity.Cita;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CitaMapeador {
    CitaModelo convertirCitaModelo(Cita cita);

    @InheritInverseConfiguration
    Cita convertirCita(CitaModelo citaModelo);
}
