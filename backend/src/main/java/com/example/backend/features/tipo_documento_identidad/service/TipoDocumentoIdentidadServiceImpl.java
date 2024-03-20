package com.example.backend.features.tipo_documento_identidad.service;

import com.example.backend.features.tipo_documento_identidad.TipoDocumentoIdentidad;
import com.example.backend.features.tipo_documento_identidad.dao.TipoDocumentoIdentidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoIdentidadServiceImpl implements TipoDocumentoIdentidadService {
    private final TipoDocumentoIdentidadDao tipoDocumentoIdentidadDao;

    @Autowired
    public TipoDocumentoIdentidadServiceImpl(TipoDocumentoIdentidadDao tipoDocumentoIdentidadDao) {
        this.tipoDocumentoIdentidadDao = tipoDocumentoIdentidadDao;
    }

    @Override
    public List<TipoDocumentoIdentidad> getAllTiposDocumentoIdentidad() {
        return tipoDocumentoIdentidadDao.findAll();
    }

    @Override
    public TipoDocumentoIdentidad getTipoDocumentoIdentidadById(Integer id) {
        Optional<TipoDocumentoIdentidad> tipoDocumentoIdentidadOptional = tipoDocumentoIdentidadDao.findById(id);
        return tipoDocumentoIdentidadOptional.orElse(null);
    }

    @Override
    public TipoDocumentoIdentidad createTipoDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        return tipoDocumentoIdentidadDao.save(tipoDocumentoIdentidad);
    }

    @Override
    public TipoDocumentoIdentidad updateTipoDocumentoIdentidad(Integer id, TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        if (tipoDocumentoIdentidadDao.existsById(id)) {
            tipoDocumentoIdentidad.setIdTipoDocumentoIdentidad(id);
            return tipoDocumentoIdentidadDao.save(tipoDocumentoIdentidad);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTipoDocumentoIdentidad(Integer id) {
        tipoDocumentoIdentidadDao.deleteById(id);
    }
}
