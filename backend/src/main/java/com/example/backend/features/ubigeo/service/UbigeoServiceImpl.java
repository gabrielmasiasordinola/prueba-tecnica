package com.example.backend.features.ubigeo.service;

import com.example.backend.features.ubigeo.Ubigeo;
import com.example.backend.features.ubigeo.dao.UbigeoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbigeoServiceImpl implements UbigeoService {

    private final UbigeoDao ubigeoDao;

    @Autowired
    public UbigeoServiceImpl(UbigeoDao ubigeoDao) {
        this.ubigeoDao = ubigeoDao;
    }

    @Override
    public List<Ubigeo> obtenerTodos() {
        return ubigeoDao.findAll();
    }

    @Override
    public Ubigeo guardarUbigeo(Ubigeo ubigeo) {
        return ubigeoDao.save(ubigeo);
    }

    @Override
    public Ubigeo obtenerUbigeoPorCodigo(String codigoUbigeo) {
        return ubigeoDao.findById(codigoUbigeo).orElse(null);
    }

    @Override
    public Ubigeo actualizarUbigeo(String codigoUbigeo, Ubigeo ubigeo) {
        if (ubigeoDao.existsById(codigoUbigeo)) {
            ubigeo.setCodigoUbigeo(codigoUbigeo);
            return ubigeoDao.save(ubigeo);
        }
        return null;
    }

    @Override
    public void eliminarUbigeo(String codigoUbigeo) {
        ubigeoDao.deleteById(codigoUbigeo);
    }

    @Override
    public List<Ubigeo> findUbigeosWithEmptyOr00Values() {
        return ubigeoDao.findUbigeosWithEmptyOr00Values();
    }

    @Override
    public List<Ubigeo> findUbigeosByCodigoProvinciaAndDistritoEmptyOr00(String codigoDepartamento) {
        return ubigeoDao.findUbigeosByCodigoProvinciaAndDistritoEmptyOr00(codigoDepartamento);
    }

    @Override
    public List<Ubigeo> findUbigeosByCodigoDistrito(String codigoDistrito, String codigoDepartamento) {
        return ubigeoDao.findUbigeosByCodigoDistrito(codigoDistrito, codigoDepartamento);
    }
}
