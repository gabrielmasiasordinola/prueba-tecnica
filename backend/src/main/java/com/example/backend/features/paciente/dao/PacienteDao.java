package com.example.backend.features.paciente.dao;

import com.example.backend.features.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteDao extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByIdTipoDocideAndNoDocideLikeIgnoreCase(Integer idTipoDocide, String noDocide);

    List<Paciente> findByNoApepatContainsOrNoApematContainsOrNoNombresContains(
            String noApepat, String noApemat, String nombre);

}
