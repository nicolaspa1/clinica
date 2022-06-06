package com.ufps.clinica.persistence.repository;

import com.ufps.clinica.persistence.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findByDocumento(String documento);
}
