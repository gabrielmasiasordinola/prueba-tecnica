package com.example.backend.features.parentesco.controller;

import com.example.backend.features.parentesco.Parentesco;
import com.example.backend.features.parentesco.service.ParentescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parentesco")
public class ParentescoController {

    private final ParentescoService parentescoService;

    @Autowired
    public ParentescoController(ParentescoService parentescoService) {
        this.parentescoService = parentescoService;
    }

    @GetMapping
    public ResponseEntity<List<Parentesco>> getAllParentescos() {
        List<Parentesco> parentescos = parentescoService.getAllParentescos();
        return ResponseEntity.ok(parentescos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parentesco> getParentescoById(@PathVariable Integer id) {
        Parentesco parentesco = parentescoService.getParentescoById(id);
        if (parentesco != null) {
            return ResponseEntity.ok(parentesco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Parentesco> createParentesco(@RequestBody Parentesco parentesco) {
        Parentesco createdParentesco = parentescoService.createParentesco(parentesco);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParentesco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parentesco> updateParentesco(@PathVariable Integer id, @RequestBody Parentesco parentesco) {
        Parentesco updatedParentesco = parentescoService.updateParentesco(id, parentesco);
        if (updatedParentesco != null) {
            return ResponseEntity.ok(updatedParentesco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParentesco(@PathVariable Integer id) {
        parentescoService.deleteParentesco(id);
        return ResponseEntity.noContent().build();
    }
}
