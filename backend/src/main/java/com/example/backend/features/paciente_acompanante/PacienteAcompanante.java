package com.example.backend.features.paciente_acompanante;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_paciente_acompanante", schema = "admision")
public class PacienteAcompanante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente_acompanante")
    private Integer idPacienteAcompanante;

    @Column(name = "id_paciente", nullable = false)
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

    @Column(name = "fe_nacimiento")
    private Date feNacimiento;

    @Column(name = "id_parentesco")
    private Integer idParentesco;

    @Column(name = "nu_telefo_contacto")
    private String nuTelefoContacto;

    @Column(name = "no_direccion")
    private String noDireccion;

    @Column(name = "co_ubigeo", length = 6)
    private String coUbigeo;

}
