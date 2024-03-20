package com.example.backend.features.tipo_documento_identidad.controller;

import com.example.backend.features.tipo_documento_identidad.TipoDocumentoIdentidad;
import com.example.backend.features.tipo_documento_identidad.service.TipoDocumentoIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-documento-identidad")
public class TipoDocumentoIdentidadController {
    private final TipoDocumentoIdentidadService tipoDocumentoIdentidadService;

    @Autowired
    public TipoDocumentoIdentidadController(TipoDocumentoIdentidadService tipoDocumentoIdentidadService) {
        this.tipoDocumentoIdentidadService = tipoDocumentoIdentidadService;
    }

    @GetMapping
    public ResponseEntity<List<TipoDocumentoIdentidad>> getAllTiposDocumentoIdentidad() {
        List<TipoDocumentoIdentidad> tiposDocumentoIdentidad = tipoDocumentoIdentidadService.getAllTiposDocumentoIdentidad();
        return ResponseEntity.ok(tiposDocumentoIdentidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoIdentidad> getTipoDocumentoIdentidadById(@PathVariable Integer id) {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = tipoDocumentoIdentidadService.getTipoDocumentoIdentidadById(id);
        if (tipoDocumentoIdentidad != null) {
            return ResponseEntity.ok(tipoDocumentoIdentidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoDocumentoIdentidad> createTipoDocumentoIdentidad(@RequestBody TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        TipoDocumentoIdentidad createdTipoDocumentoIdentidad = tipoDocumentoIdentidadService.createTipoDocumentoIdentidad(tipoDocumentoIdentidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTipoDocumentoIdentidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumentoIdentidad> updateTipoDocumentoIdentidad(@PathVariable Integer id, @RequestBody TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        TipoDocumentoIdentidad updatedTipoDocumentoIdentidad = tipoDocumentoIdentidadService.updateTipoDocumentoIdentidad(id, tipoDocumentoIdentidad);
        if (updatedTipoDocumentoIdentidad != null) {
            return ResponseEntity.ok(updatedTipoDocumentoIdentidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDocumentoIdentidad(@PathVariable Integer id) {
        tipoDocumentoIdentidadService.deleteTipoDocumentoIdentidad(id);
        return ResponseEntity.noContent().build();
    }
}
