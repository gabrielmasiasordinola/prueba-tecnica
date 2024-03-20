package com.example.backend.features.sexo.service;

import com.example.backend.features.sexo.Sexo;

import java.util.List;

public interface SexoService {
    List<Sexo> getAllSexo();
    Sexo getSexoById(Integer id);
    Sexo saveSexo(Sexo sexo);
    void deleteSexo(Integer id);
}
