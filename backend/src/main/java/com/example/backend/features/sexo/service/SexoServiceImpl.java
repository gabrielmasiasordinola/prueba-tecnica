package com.example.backend.features.sexo.service;

import com.example.backend.features.sexo.Sexo;
import com.example.backend.features.sexo.dao.SexoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SexoServiceImpl implements SexoService {

    private final SexoDao sexoDao;

    @Autowired
    public SexoServiceImpl(SexoDao sexoDao) {
        this.sexoDao = sexoDao;
    }

    @Override
    public List<Sexo> getAllSexo() {
        return sexoDao.findAll();
    }

    @Override
    public Sexo getSexoById(Integer id) {
        Optional<Sexo> optionalSexo = sexoDao.findById(id);
        return optionalSexo.orElse(null);
    }

    @Override
    public Sexo saveSexo(Sexo sexo) {
        return sexoDao.save(sexo);
    }

    @Override
    public void deleteSexo(Integer id) {
        sexoDao.deleteById(id);
    }
}
