package com.ufps.clinica.domain.servicio.interfaces;

import com.ufps.clinica.domain.modelo.MedicoModelo;
import com.ufps.clinica.domain.modelo.PacienteModelo;

import java.util.List;


public interface MedicoServicio {
    public abstract MedicoModelo obtenerMedicoPorId(Long id);
    public abstract List<MedicoModelo> obtenerMedicos();
    public abstract MedicoModelo guardar(MedicoModelo medicoModelo);
    public abstract void eliminar(Long id);
    public abstract MedicoModelo actualizar(MedicoModelo medicoModelo);


}
