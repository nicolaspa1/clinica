package com.ufps.clinica.persistence.mapper;

import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.persistence.entity.Medico;
import org.mapstruct.InheritInverseConfiguration;

public interface Paciente {
    PacienteModelo convertirPacienteModelo(Paciente paciente);

    @InheritInverseConfiguration
    Paciente convertirPaciente(PacienteModelo pacienteModeloModelo);
}
