package com.ufps.clinica.persistence.mapper;

import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.persistence.entity.Paciente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapeador {
    PacienteModelo convertirPacienteModelo(Paciente paciente);

    @InheritInverseConfiguration
    Paciente convertirPaciente(PacienteModelo pacienteModelo);
}
