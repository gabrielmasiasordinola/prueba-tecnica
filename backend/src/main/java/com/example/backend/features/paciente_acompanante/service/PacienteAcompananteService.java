package com.example.backend.features.paciente_acompanante.service;

import com.example.backend.features.paciente_acompanante.PacienteAcompanante;

import java.util.List;

public interface PacienteAcompananteService {
    List<PacienteAcompanante> getAllPacientesAcompanantes();

    PacienteAcompanante getPacienteAcompananteById(Integer id);

    PacienteAcompanante createPacienteAcompanante(PacienteAcompanante pacienteAcompanante);

    PacienteAcompanante updatePacienteAcompanante(Integer id, PacienteAcompanante pacienteAcompanante);

    void deletePacienteAcompanante(Integer id);
}
