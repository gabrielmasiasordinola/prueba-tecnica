package com.example.backend.features.tipo_documento_identidad.service;

import com.example.backend.features.tipo_documento_identidad.TipoDocumentoIdentidad;

import java.util.List;

public interface TipoDocumentoIdentidadService {
    List<TipoDocumentoIdentidad> getAllTiposDocumentoIdentidad();

    TipoDocumentoIdentidad getTipoDocumentoIdentidadById(Integer id);

    TipoDocumentoIdentidad createTipoDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad);

    TipoDocumentoIdentidad updateTipoDocumentoIdentidad(Integer id, TipoDocumentoIdentidad tipoDocumentoIdentidad);

    void deleteTipoDocumentoIdentidad(Integer id);
}
