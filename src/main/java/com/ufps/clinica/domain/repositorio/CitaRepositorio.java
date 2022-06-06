package com.ufps.clinica.domain.repositorio;

import com.ufps.clinica.domain.modelo.CitaModelo;
import com.ufps.clinica.persistence.entity.Cita;
import com.ufps.clinica.persistence.mapper.CitaMapeador;
import com.ufps.clinica.persistence.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CitaRepositorio {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private CitaMapeador citaMapeador;

    public Optional<CitaModelo> obtenerCitaPorId(Long idCita){
        Optional<Cita> cita = citaRepository.findById(idCita);
        return Optional.ofNullable(citaMapeador.convertirCitaModelo(cita.get()));
    }
    public Optional<CitaModelo> guardar(CitaModelo citaModelo){
        Cita cita = citaMapeador.convertirCita(citaModelo);
        return Optional.of(citaMapeador.convertirCitaModelo(citaRepository.save(cita)));
    }
    public void eliminar(Long id){
        citaRepository.deleteById(id);
    }

}
