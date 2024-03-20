package com.example.backend.features.parentesco.service;

import com.example.backend.features.parentesco.Parentesco;
import com.example.backend.features.parentesco.dao.ParentescoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentescoServiceImpl implements ParentescoService {

    private final ParentescoDao parentescoDao;

    @Autowired
    public ParentescoServiceImpl(ParentescoDao parentescoDao) {
        this.parentescoDao = parentescoDao;
    }

    @Override
    public List<Parentesco> getAllParentescos() {
        return parentescoDao.findAll();
    }

    @Override
    public Parentesco getParentescoById(Integer id) {
        Optional<Parentesco> parentescoOptional = parentescoDao.findById(id);
        return parentescoOptional.orElse(null);
    }

    @Override
    public Parentesco createParentesco(Parentesco parentesco) {
        return parentescoDao.save(parentesco);
    }

    @Override
    public Parentesco updateParentesco(Integer id, Parentesco parentesco) {
        if (parentescoDao.existsById(id)) {
            parentesco.setIdParentesco(id);
            return parentescoDao.save(parentesco);
        } else {
            return null;
        }
    }

    @Override
    public void deleteParentesco(Integer id) {
        parentescoDao.deleteById(id);
    }
}
