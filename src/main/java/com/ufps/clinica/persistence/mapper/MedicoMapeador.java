package com.ufps.clinica.persistence.mapper;

import com.ufps.clinica.domain.modelo.MedicoModelo;
import com.ufps.clinica.persistence.entity.Medico;
import org.mapstruct.InheritInverseConfiguration;

public interface MedicoMapeador {
    MedicoModelo convertirMedicoModelo(Medico medico);

    @InheritInverseConfiguration
    Medico convertirMedico(MedicoModelo medicoModeloModelo);
}
