package com.example.backend.features.paciente_acompanante.dao;

import com.example.backend.features.paciente_acompanante.PacienteAcompanante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteAcompananteDao extends JpaRepository<PacienteAcompanante, Integer> {

}
