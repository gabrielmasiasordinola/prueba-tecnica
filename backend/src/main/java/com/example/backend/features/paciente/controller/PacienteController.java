package com.example.backend.features.paciente.controller;

import com.example.backend.features.paciente.Paciente;
import com.example.backend.features.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Integer id) {
        Paciente paciente = pacienteService.getPacienteById(id);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente createdPaciente = pacienteService.createPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
        Paciente updatedPaciente = pacienteService.updatePaciente(id, paciente);
        if (updatedPaciente != null) {
            return ResponseEntity.ok(updatedPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Integer id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idDocide}/{noDocide}")
    public ResponseEntity<List<Paciente>> getPacientesByIdDocideAndNoDocide(
            @PathVariable Integer idDocide,
            @PathVariable String noDocide
    ) {
        List<Paciente> pacientes = pacienteService.getPacienteByIdDocideAndNoDocide(idDocide, noDocide);
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{apellidopat}/{apellidomat}/{nombres}")
    public ResponseEntity<List<Paciente>> getPacientesByApellidosAndNombres(
            @PathVariable String apellidopat,
            @PathVariable String apellidomat,
            @PathVariable String nombres
    ) {
        List<Paciente> pacientes = pacienteService.getPacienteByApellidosAndNombres(apellidopat, apellidomat, nombres);
        return ResponseEntity.ok(pacientes);
    }
}
