package com.example.backend.features.ubigeo.dao;

import com.example.backend.features.ubigeo.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoDao extends JpaRepository<Ubigeo, String> {
    @Query("SELECT u FROM Ubigeo u WHERE u.descripcionProvincia = '' AND u.descripcionDistrito = '' AND u.codigoProvincia = '00' AND u.codigoDistrito = '00'")
    List<Ubigeo> findUbigeosWithEmptyOr00Values();

    @Query("SELECT u FROM Ubigeo u WHERE u.codigoDepartamento = :codigoDepartamento AND u.codigoDistrito = '00' AND u.descripcionDistrito = ''")
    List<Ubigeo> findUbigeosByCodigoProvinciaAndDistritoEmptyOr00(String codigoDepartamento);

    @Query("SELECT u FROM Ubigeo u WHERE u.codigoProvincia = :codigoProvincia AND u.codigoDepartamento = :codigoDepartamento")
    List<Ubigeo> findUbigeosByCodigoDistrito(String codigoProvincia, String codigoDepartamento);
}
