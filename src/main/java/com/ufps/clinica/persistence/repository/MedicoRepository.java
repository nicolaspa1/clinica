package com.ufps.clinica.persistence.repository;

import com.ufps.clinica.persistence.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
