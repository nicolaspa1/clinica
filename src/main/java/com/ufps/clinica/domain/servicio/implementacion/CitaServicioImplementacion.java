package com.ufps.clinica.domain.servicio.implementacion;

import com.ufps.clinica.domain.modelo.CitaModelo;
import com.ufps.clinica.domain.modelo.MedicoModelo;
import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.domain.repositorio.CitaRepositorio;
import com.ufps.clinica.domain.repositorio.MedicoRepositorio;
import com.ufps.clinica.domain.repositorio.PacienteRepositorio;
import com.ufps.clinica.domain.servicio.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServicioImplementacion implements CitaServicio {
    @Autowired
    private CitaRepositorio citaRepositorio;

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Override
    @Transactional
    public CitaModelo obtenerCitaPorId(Long id) {
        Optional<CitaModelo> citaModelo = citaRepositorio.obtenerCitaPorId(id);
        return citaModelo.get();
    }

    @Override
    public List<CitaModelo> obtenerCitas() {
        List<CitaModelo> citasModelo=citaRepositorio.obtenerCitas();
        return citasModelo;
    }

    @Override
    @Transactional
    public CitaModelo guardar(CitaModelo citaModelo) {
        if(citaModelo.getMedicoModelo()!=null) {
            long idMedicoModelo = citaModelo.getMedicoModelo().getIdMedico();
            Optional<MedicoModelo> mM = medicoRepositorio.obtenerMedicoPorId(idMedicoModelo);
            citaModelo.setMedicoModelo(mM.get());
        }
        if (citaModelo.getPacienteModelo() != null) {
            long idPacienteModelo = citaModelo.getPacienteModelo().getIdPaciente();
            Optional<PacienteModelo> pM = pacienteRepositorio.obtenerPacientePorId(idPacienteModelo);
            citaModelo.setPacienteModelo(pM.get());
        }

        return citaRepositorio.guardar(citaModelo).get();

    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        CitaModelo citaModelo = obtenerCitaPorId(id);
        if (citaModelo != null) {
            citaRepositorio.eliminar(id);
        }
    }

    @Override
    @Transactional
    public CitaModelo actualizar(CitaModelo citaModelo) {
        if(citaModelo.getMedicoModelo()!=null) {
            long idMedicoModelo = citaModelo.getMedicoModelo().getIdMedico();
            Optional<MedicoModelo> mM = medicoRepositorio.obtenerMedicoPorId(idMedicoModelo);
            citaModelo.setMedicoModelo(mM.get());
        }
        if (citaModelo.getPacienteModelo() != null) {
            long idPacienteModelo = citaModelo.getPacienteModelo().getIdPaciente();
            Optional<PacienteModelo> pM = pacienteRepositorio.obtenerPacientePorId(idPacienteModelo);
            citaModelo.setPacienteModelo(pM.get());
        }
        return citaRepositorio.guardar(citaModelo).get();
    }
}
