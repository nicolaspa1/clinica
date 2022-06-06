package com.ufps.clinica.persistence.repository;

import com.ufps.clinica.persistence.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita,Long> {
}
