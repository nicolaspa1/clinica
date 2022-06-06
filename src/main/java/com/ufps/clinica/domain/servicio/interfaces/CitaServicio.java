package com.ufps.clinica.domain.servicio.interfaces;

import com.ufps.clinica.domain.modelo.CitaModelo;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface CitaServicio {
    public abstract CitaModelo obtenerCitaPorId(Long id);
    public abstract CitaModelo guardar(CitaModelo citaModelo);
    public abstract void eliminar(Long id);
    public abstract CitaModelo actualizar(CitaModelo citaModelo);


}
