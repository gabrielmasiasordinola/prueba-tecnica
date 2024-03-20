package com.example.backend.features.ubigeo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tc_ubigeo", schema = "admision")
public class Ubigeo {

    @Id
    @Column(name = "codigo_ubigeo", nullable = false)
    private String codigoUbigeo;

    @Column(name = "descripcion_departamento", length = 200)
    private String descripcionDepartamento;

    @Column(name = "descripcion_provincia", length = 200)
    private String descripcionProvincia;

    @Column(name = "descripcion_distrito", length = 200)
    private String descripcionDistrito;

    @Column(name = "fl_estado")
    private boolean estado;

    @Column(name = "codigo_departamento", length = 2)
    private String codigoDepartamento;

    @Column(name = "codigo_provincia", length = 2)
    private String codigoProvincia;

    @Column(name = "codigo_distrito", length = 2)
    private String codigoDistrito;

}
