package com.ufps.clinica.domain.servicio.implementacion;

import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.domain.repositorio.PacienteRepositorio;
import com.ufps.clinica.domain.servicio.interfaces.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServicioImplementacion implements PacienteServicio {
    @Autowired
    private PacienteRepositorio pacienteRepositorio;



    @Override
    @Transactional
    public PacienteModelo obtenerPacientePorId(Long id) {
        Optional<PacienteModelo> pacienteModelo = pacienteRepositorio.obtenerPacientePorId(id);
        return pacienteModelo.get();
    }

    @Override
    public List<PacienteModelo> obtenerPacientes() {
        List<PacienteModelo> pacientesModelo=pacienteRepositorio.obtenerPacientes();
        return pacientesModelo;
    }

    @Override
    @Transactional
    public PacienteModelo guardar(PacienteModelo pacienteModelo) {


        return pacienteRepositorio.guardar(pacienteModelo).get();

    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        PacienteModelo pacienteModelo = obtenerPacientePorId(id);
        if (pacienteModelo != null) {
            pacienteRepositorio.eliminar(id);
        }
    }

    @Override
    @Transactional
    public PacienteModelo actualizar(PacienteModelo pacienteModelo) {




        return pacienteRepositorio.guardar(pacienteModelo).get();
    }
}
