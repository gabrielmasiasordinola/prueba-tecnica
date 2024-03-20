package com.example.backend.features.parentesco.service;

import com.example.backend.features.parentesco.Parentesco;

import java.util.List;

public interface ParentescoService {
    List<Parentesco> getAllParentescos();

    Parentesco getParentescoById(Integer id);

    Parentesco createParentesco(Parentesco parentesco);

    Parentesco updateParentesco(Integer id, Parentesco parentesco);

    void deleteParentesco(Integer id);
}
