package com.ufps.clinica.domain.repositorio;

import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.persistence.entity.Paciente;
import com.ufps.clinica.persistence.mapper.PacienteMapeador;
import com.ufps.clinica.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PacienteRepositorio {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteMapeador pacienteMapeador;

    public Optional<PacienteModelo> obtenerPacientePorId(Long idPaciente) {
        Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
        return Optional.ofNullable(pacienteMapeador.convertirPacienteModelo(paciente.get()));
    }

    public List<PacienteModelo> obtenerPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteModelo> pacientesModelo = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            PacienteModelo pacienteModelo = pacienteMapeador.convertirPacienteModelo(paciente);
            pacientesModelo.add(pacienteModelo);
        }

        return pacientesModelo;
    }

    public Optional<PacienteModelo> guardar(PacienteModelo pacienteModelo) {
        Paciente paciente;
        if (pacienteModelo.getIdPaciente() != null) {
            PacienteModelo pM = obtenerPacientePorId(pacienteModelo.getIdPaciente()).get();
            pM.setIdPaciente(pacienteModelo.getIdPaciente());
            pM.setNombre(pacienteModelo.getNombre());
            pM.setApellido(pacienteModelo.getApellido());

            paciente = pacienteMapeador.convertirPaciente(pM);

        } else {
            paciente = pacienteMapeador.convertirPaciente(pacienteModelo);
        }

        PacienteModelo pacienteModeloOut = pacienteMapeador.convertirPacienteModelo(pacienteRepository.save(paciente));

        return Optional.of(pacienteModeloOut);
    }

    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

}
