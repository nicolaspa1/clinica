package com.ufps.clinica.domain.servicio.implementacion;

import com.ufps.clinica.domain.modelo.MedicoModelo;
import com.ufps.clinica.domain.modelo.PacienteModelo;
import com.ufps.clinica.domain.repositorio.MedicoRepositorio;
import com.ufps.clinica.domain.servicio.interfaces.MedicoServicio;
import com.ufps.clinica.domain.utilidades.error.ErrorMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServicioImplementacion implements MedicoServicio {
    @Autowired
    private MedicoRepositorio medicoRepositorio;
    @Override
    @Transactional
    public MedicoModelo obtenerMedicoPorId(Long id) {
        Optional<MedicoModelo> medicoModelo = medicoRepositorio.obtenerMedicoPorId(id);
        return medicoModelo.get();
    }

    @Override
    public List<MedicoModelo> obtenerMedicos() {
        List<MedicoModelo> medicosModelo=medicoRepositorio.obtenerMedicos();
        return medicosModelo;
    }

    @Override
    @Transactional
    public MedicoModelo guardar(MedicoModelo medicoModelo) {

        return medicoRepositorio.guardar(medicoModelo).get();

    }
    @Override
    @Transactional
    public void eliminar(Long id){
        MedicoModelo medicoModelo = obtenerMedicoPorId(id);
        if (medicoModelo != null){
            medicoRepositorio.eliminar(id);
        }
    }
    @Override
    @Transactional
    public MedicoModelo actualizar(MedicoModelo medicoModelo){

        return medicoRepositorio.guardar(medicoModelo).get();
    }
}
