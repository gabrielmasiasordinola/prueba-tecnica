package com.example.backend.features.parentesco.dao;

import com.example.backend.features.parentesco.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentescoDao extends JpaRepository<Parentesco, Integer> {
}
