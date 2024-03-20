package com.example.backend.features.paciente_acompanante.service;

import com.example.backend.features.paciente_acompanante.PacienteAcompanante;
import com.example.backend.features.paciente_acompanante.dao.PacienteAcompananteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteAcompananteServiceImpl implements PacienteAcompananteService {

    private final PacienteAcompananteDao pacienteAcompananteDao;

    @Autowired
    public PacienteAcompananteServiceImpl(PacienteAcompananteDao pacienteAcompananteDao) {
        this.pacienteAcompananteDao = pacienteAcompananteDao;
    }

    @Override
    public List<PacienteAcompanante> getAllPacientesAcompanantes() {
        return pacienteAcompananteDao.findAll();
    }

    @Override
    public PacienteAcompanante getPacienteAcompananteById(Integer id) {
        Optional<PacienteAcompanante> pacienteAcompananteOptional = pacienteAcompananteDao.findById(id);
        return pacienteAcompananteOptional.orElse(null);
    }

    @Override
    public PacienteAcompanante createPacienteAcompanante(PacienteAcompanante pacienteAcompanante) {
        return pacienteAcompananteDao.save(pacienteAcompanante);
    }

    @Override
    public PacienteAcompanante updatePacienteAcompanante(Integer id, PacienteAcompanante pacienteAcompanante) {
        if (pacienteAcompananteDao.existsById(id)) {
            pacienteAcompanante.setIdPacienteAcompanante(id);
            return pacienteAcompananteDao.save(pacienteAcompanante);
        } else {
            return null;
        }
    }

    @Override
    public void deletePacienteAcompanante(Integer id) {
        pacienteAcompananteDao.deleteById(id);
    }
}
