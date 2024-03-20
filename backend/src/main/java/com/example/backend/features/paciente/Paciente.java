package com.example.backend.features.paciente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_paciente", schema = "admision")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "id_tipo_docide")
    private Integer idTipoDocide;

    @Column(name = "no_docide")
    private String noDocide;

    @Column(name = "no_apepat")
    private String noApepat;

    @Column(name = "no_apemat")
    private String noApemat;

    @Column(name = "no_nombres")
    private String noNombres;

    @Column(name = "id_sexo")
    private Integer idSexo;

    @Column(name = "fe_nacimiento")
    private Date feNacimiento;

    @Column(name = "no_lugar_nacimiento")
    private String noLugarNacimiento;

    @Column(name = "no_direccion")
    private String noDireccion;

    @Column(name = "co_ubigeo", length = 6)
    private String coUbigeo;

}
