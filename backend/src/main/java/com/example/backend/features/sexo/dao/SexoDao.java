package com.example.backend.features.sexo.dao;

import com.example.backend.features.sexo.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexoDao extends JpaRepository<Sexo, Integer> {
}
