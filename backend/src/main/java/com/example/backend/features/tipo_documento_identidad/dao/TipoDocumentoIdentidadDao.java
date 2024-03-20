package com.example.backend.features.tipo_documento_identidad.dao;

import com.example.backend.features.tipo_documento_identidad.TipoDocumentoIdentidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoIdentidadDao extends JpaRepository<TipoDocumentoIdentidad, Integer> {
}
