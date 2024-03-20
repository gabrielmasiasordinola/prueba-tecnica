package com.example.backend.features.paciente.service;

import com.example.backend.features.paciente.Paciente;
import com.example.backend.features.paciente.dao.PacienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteDao pacienteDao;

    @Autowired
    public PacienteServiceImpl(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteDao.findAll();
    }

    @Override
    public Paciente getPacienteById(Integer id) {
        Optional<Paciente> pacienteOptional = pacienteDao.findById(id);
        return pacienteOptional.orElse(null);
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return pacienteDao.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Integer id, Paciente paciente) {
        if (pacienteDao.existsById(id)) {
            paciente.setIdPaciente(id);
            return pacienteDao.save(paciente);
        } else {
            return null;
        }
    }

    @Override
    public void deletePaciente(Integer id) {
        pacienteDao.deleteById(id);
    }

    @Override
    public List<Paciente> getPacienteByIdDocideAndNoDocide(Integer idDocide, String noDocide) {
        return pacienteDao.findByIdTipoDocideAndNoDocideLikeIgnoreCase(idDocide, noDocide);
    }

    @Override
    public List<Paciente> getPacienteByApellidosAndNombres(String apellidoPat, String apellidoMat, String nombres) {
        return pacienteDao.findByNoApepatContainsOrNoApematContainsOrNoNombresContains(apellidoPat, apellidoMat, nombres);
    }

}
