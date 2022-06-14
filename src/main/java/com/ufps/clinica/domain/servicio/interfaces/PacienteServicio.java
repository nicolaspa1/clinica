package com.ufps.clinica.domain.servicio.interfaces;

import com.ufps.clinica.domain.modelo.PacienteModelo;

import java.util.List;


public interface PacienteServicio {
    public abstract PacienteModelo obtenerPacientePorId(Long id);
    public abstract List<PacienteModelo> obtenerPacientes();
    public abstract PacienteModelo guardar(PacienteModelo pacienteModelo);
    public abstract void eliminar(Long id);
    public abstract PacienteModelo actualizar(PacienteModelo pacienteModelo);


}
