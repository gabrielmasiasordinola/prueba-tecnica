package com.example.backend.features.tipo_documento_identidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tc_tipo_documento_identidad", schema = "admision")
public class TipoDocumentoIdentidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento_identidad")
    private Integer idTipoDocumentoIdentidad;

    @Column(name = "descripcion_tipo_documento_identidad", length = 50)
    private String descripcionTipoDocumentoIdentidad;

    @Column(name = "codigo_ieds", length = 2)
    private String codigoIeds;

    @Column(name = "fl_estado", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean estado;

    // Getters y setters
}
