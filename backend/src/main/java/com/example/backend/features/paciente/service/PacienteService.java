package com.example.backend.features.paciente.service;

import com.example.backend.features.paciente.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> getAllPacientes();

    Paciente getPacienteById(Integer id);

    Paciente createPaciente(Paciente paciente);

    Paciente updatePaciente(Integer id, Paciente paciente);

    void deletePaciente(Integer id);

    List<Paciente> getPacienteByIdDocideAndNoDocide(Integer idDocide, String NoDocide);

    List<Paciente> getPacienteByApellidosAndNombres(String apellidoPat, String apellidoMat, String nombres);
}
