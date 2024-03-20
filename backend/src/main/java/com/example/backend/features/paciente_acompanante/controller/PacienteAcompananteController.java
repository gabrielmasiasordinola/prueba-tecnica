package com.example.backend.features.paciente_acompanante.controller;

import com.example.backend.features.paciente_acompanante.PacienteAcompanante;
import com.example.backend.features.paciente_acompanante.service.PacienteAcompananteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes-acompanantes")
public class PacienteAcompananteController {

    private final PacienteAcompananteService pacienteAcompananteService;

    @Autowired
    public PacienteAcompananteController(PacienteAcompananteService pacienteAcompananteService) {
        this.pacienteAcompananteService = pacienteAcompananteService;
    }

    @GetMapping
    public ResponseEntity<List<PacienteAcompanante>> getAllPacientesAcompanantes() {
        List<PacienteAcompanante> pacientesAcompanantes = pacienteAcompananteService.getAllPacientesAcompanantes();
        return ResponseEntity.ok(pacientesAcompanantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteAcompanante> getPacienteAcompananteById(@PathVariable Integer id) {
        PacienteAcompanante pacienteAcompanante = pacienteAcompananteService.getPacienteAcompananteById(id);
        if (pacienteAcompanante != null) {
            return ResponseEntity.ok(pacienteAcompanante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PacienteAcompanante> createPacienteAcompanante(@RequestBody PacienteAcompanante pacienteAcompanante) {
        PacienteAcompanante createdPacienteAcompanante = pacienteAcompananteService.createPacienteAcompanante(pacienteAcompanante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPacienteAcompanante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteAcompanante> updatePacienteAcompanante(@PathVariable Integer id, @RequestBody PacienteAcompanante pacienteAcompanante) {
        PacienteAcompanante updatedPacienteAcompanante = pacienteAcompananteService.updatePacienteAcompanante(id, pacienteAcompanante);
        if (updatedPacienteAcompanante != null) {
            return ResponseEntity.ok(updatedPacienteAcompanante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacienteAcompanante(@PathVariable Integer id) {
        pacienteAcompananteService.deletePacienteAcompanante(id);
        return ResponseEntity.noContent().build();
    }
}
