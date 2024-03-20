package com.example.backend.features.ubigeo.service;

import com.example.backend.features.ubigeo.Ubigeo;

import java.util.List;

public interface UbigeoService {
    List<Ubigeo> obtenerTodos();

    Ubigeo guardarUbigeo(Ubigeo ubigeo);

    Ubigeo obtenerUbigeoPorCodigo(String codigoUbigeo);

    Ubigeo actualizarUbigeo(String codigoUbigeo, Ubigeo ubigeo);

    void eliminarUbigeo(String codigoUbigeo);

    List<Ubigeo> findUbigeosWithEmptyOr00Values();

    List<Ubigeo> findUbigeosByCodigoProvinciaAndDistritoEmptyOr00(String codigoProvincia);

    List<Ubigeo> findUbigeosByCodigoDistrito(String codigoDistrito, String codigoDepartamento);
}
