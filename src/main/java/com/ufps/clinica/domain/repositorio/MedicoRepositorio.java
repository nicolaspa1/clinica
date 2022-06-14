package com.ufps.clinica.domain.repositorio;

import com.ufps.clinica.domain.modelo.MedicoModelo;
import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.persistence.entity.Medico;
import com.ufps.clinica.persistence.entity.Paciente;
import com.ufps.clinica.persistence.mapper.MedicoMapeador;
import com.ufps.clinica.persistence.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicoRepositorio {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoMapeador medicoMapeador;

    public Optional<MedicoModelo> obtenerMedicoPorId(Long idMedico) {
        Optional<Medico> medico = medicoRepository.findById(idMedico);
        return Optional.ofNullable(medicoMapeador.convertirMedicoModelo(medico.get()));
    }

    public List<MedicoModelo> obtenerMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoModelo> medicosModelo = new ArrayList<>();
        for (Medico medico : medicos) {
            MedicoModelo medicoModelo = medicoMapeador.convertirMedicoModelo(medico);
            medicosModelo.add(medicoModelo);
        }

        return medicosModelo;
    }

    public Optional<MedicoModelo> guardar(MedicoModelo medicoModelo) {
        Medico medico;
        if (medicoModelo.getIdMedico() != null) {
            MedicoModelo mM = obtenerMedicoPorId(medicoModelo.getIdMedico()).get();
            mM.setIdMedico(medicoModelo.getIdMedico());
            mM.setNombre(medicoModelo.getNombre());
            mM.setApellido(medicoModelo.getApellido());
            mM.setEspecialidadModelo(medicoModelo.getEspecialidadModelo());

            medico = medicoMapeador.convertirMedico(mM);

        } else {
            medico = medicoMapeador.convertirMedico(medicoModelo);
        }

        MedicoModelo medicoModeloOut = medicoMapeador.convertirMedicoModelo(medicoRepository.save(medico));

        return Optional.of(medicoModeloOut);
    }

    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }

}
