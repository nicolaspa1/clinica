package com.ufps.clinica.domain.servicio.implementacion;

import com.ufps.clinica.domain.modelo.CitaModelo;
import com.ufps.clinica.domain.repositorio.CitaRepositorio;
import com.ufps.clinica.domain.servicio.interfaces.CitaServicio;
import com.ufps.clinica.domain.utilidades.error.ErrorMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CitaServicioImplementacion implements CitaServicio {
    @Autowired
    private CitaRepositorio citaRepositorio;
    @Override
    @Transactional
    public CitaModelo obtenerCitaPorId(Long id) {
        Optional<CitaModelo> citaModelo = citaRepositorio.obtenerCitaPorId(id);
        return citaModelo.get();
    }

    @Override
    @Transactional
    public CitaModelo guardar(CitaModelo citaModelo) {
        if (obtenerCitaPorId(citaModelo.getIdCita())!=null){
            //lanzar excepcion ilegalArgumetException
            throw new IllegalArgumentException(ErrorMensaje.citaNoExiste(citaModelo.getIdCita()));
        }
        return citaRepositorio.guardar(citaModelo).get();

    }
    @Override
    @Transactional
    public void eliminar(Long id){
        CitaModelo citaModelo = obtenerCitaPorId(id);
        if (citaModelo != null){
            citaRepositorio.eliminar(id);
        }
    }
    @Override
    @Transactional
    public CitaModelo actualizar(CitaModelo citaModelo){
        CitaModelo citaModelo1 = obtenerCitaPorId(citaModelo.getIdCita());
        if (citaModelo1 == null) {
            throw new RuntimeException(ErrorMensaje.citaNoExiste(citaModelo.getIdCita()));
        }
        return citaRepositorio.guardar(citaModelo).get();
    }
}
