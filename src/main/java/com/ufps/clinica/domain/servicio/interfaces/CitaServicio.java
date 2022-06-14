package com.ufps.clinica.domain.servicio.interfaces;

import com.ufps.clinica.domain.modelo.CitaModelo;


import java.util.List;


public interface CitaServicio {
    public abstract CitaModelo obtenerCitaPorId(Long id);
    public abstract List<CitaModelo> obtenerCitas();
    public abstract CitaModelo guardar(CitaModelo citaModelo);
    public abstract void eliminar(Long id);
    public abstract CitaModelo actualizar(CitaModelo citaModelo);


}
