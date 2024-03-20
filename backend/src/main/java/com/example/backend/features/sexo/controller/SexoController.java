package com.example.backend.features.sexo.controller;

import com.example.backend.features.sexo.Sexo;
import com.example.backend.features.sexo.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sexo")
public class SexoController {

    private final SexoService sexoService;

    @Autowired
    public SexoController(SexoService sexoService) {
        this.sexoService = sexoService;
    }

    @GetMapping
    public ResponseEntity<List<Sexo>> getAllSexo() {
        List<Sexo> sexos = sexoService.getAllSexo();
        return new ResponseEntity<>(sexos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sexo> getSexoById(@PathVariable Integer id) {
        Sexo sexo = sexoService.getSexoById(id);
        if (sexo != null) {
            return new ResponseEntity<>(sexo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Sexo> createSexo(@RequestBody Sexo sexo) {
        Sexo newSexo = sexoService.saveSexo(sexo);
        return new ResponseEntity<>(newSexo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Sexo> updateSexo(@PathVariable Integer id, @RequestBody Sexo sexoDetails) {
        Sexo sexo = sexoService.getSexoById(id);
        if (sexo != null) {
            sexo.setDescripcionSexo(sexoDetails.getDescripcionSexo());

            Sexo updatedSexo = sexoService.saveSexo(sexo);
            return new ResponseEntity<>(updatedSexo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSexo(@PathVariable Integer id) {
        Sexo sexo = sexoService.getSexoById(id);
        if (sexo != null) {
            sexoService.deleteSexo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
