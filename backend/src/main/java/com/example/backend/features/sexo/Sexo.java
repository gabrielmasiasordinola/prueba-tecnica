package com.example.backend.features.sexo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tc_sexo", schema = "Admision")
public class Sexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sexo")
    private Integer idSexo;

    @Column(name = "descripcion_sexo", length = 25)
    private String descripcionSexo;

    @Column(name = "fl_estado", columnDefinition = "BIT(1)")
    private Boolean estado;
}
