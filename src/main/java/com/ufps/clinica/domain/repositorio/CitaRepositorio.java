package com.ufps.clinica.domain.repositorio;

import com.ufps.clinica.domain.modelo.CitaModelo;
import com.ufps.clinica.domain.modelo.MedicoModelo;
import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.persistence.entity.Cita;
import com.ufps.clinica.persistence.entity.Medico;
import com.ufps.clinica.persistence.entity.Paciente;
import com.ufps.clinica.persistence.mapper.CitaMapeador;
import com.ufps.clinica.persistence.mapper.MedicoMapeador;
import com.ufps.clinica.persistence.mapper.PacienteMapeador;
import com.ufps.clinica.persistence.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CitaRepositorio {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private CitaMapeador citaMapeador;
    @Autowired
    private MedicoMapeador medicoMapeador;
    @Autowired
    private PacienteMapeador pacienteMapeador;



    public Optional<CitaModelo> obtenerCitaPorId(Long idCita) {
        //cita,medico y paciente provenientes de la bd
        Optional<Cita> cita = citaRepository.findById(idCita);
        Medico medico = cita.get().getMedico();
        Paciente paciente=cita.get().getPaciente();
        //Mapeo de entidades a modelos
        CitaModelo citaModelo = citaMapeador.convertirCitaModelo(cita.get());
        MedicoModelo medicoModelo = medicoMapeador.convertirMedicoModelo(medico);
        PacienteModelo pacienteModelo=pacienteMapeador.convertirPacienteModelo(paciente);
        citaModelo.setMedicoModelo(medicoModelo);
        citaModelo.setPacienteModelo(pacienteModelo);
        return Optional.ofNullable(citaModelo);
    }

    public List<CitaModelo> obtenerCitas() {
        List<Cita> citas = citaRepository.findAll();
        List<CitaModelo> citasModelo = new ArrayList<>();
        for (Cita cita : citas) {
            CitaModelo citaModelo = citaMapeador.convertirCitaModelo(cita);
            MedicoModelo medicoModelo = medicoMapeador.convertirMedicoModelo(cita.getMedico());
            PacienteModelo pacienteModelo=pacienteMapeador.convertirPacienteModelo(cita.getPaciente());
            citaModelo.setMedicoModelo(medicoModelo);
            citaModelo.setPacienteModelo(pacienteModelo);
            citasModelo.add(citaModelo);
        }

        return citasModelo;
    }

    public Optional<CitaModelo> guardar(CitaModelo citaModelo) {

        Cita cita = citaMapeador.convertirCita(citaModelo);
        Medico medico=medicoMapeador.convertirMedico(citaModelo.getMedicoModelo());
        Paciente paciente=pacienteMapeador.convertirPaciente(citaModelo.getPacienteModelo());

        cita.setMedico(medico);
        cita.setPaciente(paciente);

        CitaModelo citaModeloOut = citaMapeador.convertirCitaModelo(citaRepository.save(cita));
        if (citaModelo.getMedicoModelo() != null) {
            MedicoModelo medicoModelo = citaModelo.getMedicoModelo();
            citaModeloOut.setMedicoModelo(medicoModelo);
        }
        if (citaModelo.getPacienteModelo() != null) {
            PacienteModelo pacienteModelo = citaModelo.getPacienteModelo();
            citaModeloOut.setPacienteModelo(pacienteModelo);
        }
        return Optional.of(citaModeloOut);
    }

    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }

}
