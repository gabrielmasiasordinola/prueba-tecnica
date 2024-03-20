package com.example.backend.features.parentesco;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tc_parentesco", schema = "admision")
public class Parentesco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parentesco")
    private Integer idParentesco;

    @Column(name = "no_parentesco", nullable = false)
    private String nombreParentesco;

    @Column(name = "il_activo", nullable = false)
    private Boolean activo;
    
}
