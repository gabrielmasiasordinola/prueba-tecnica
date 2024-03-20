package com.example.backend.features.ubigeo.controller;

import com.example.backend.features.ubigeo.Ubigeo;
import com.example.backend.features.ubigeo.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubigeos")
public class UbigeoController {

    @Autowired
    private UbigeoService ubigeoService;

    @GetMapping
    public List<Ubigeo> obtenerTodosLosUbigeos() {
        return ubigeoService.obtenerTodos();
    }

    @GetMapping("/{codigoUbigeo}")
    public Ubigeo obtenerUbigeoPorCodigo(@PathVariable String codigoUbigeo) {
        return ubigeoService.obtenerUbigeoPorCodigo(codigoUbigeo);
    }

    @PostMapping
    public Ubigeo crearUbigeo(@RequestBody Ubigeo ubigeo) {
        return ubigeoService.guardarUbigeo(ubigeo);
    }

    @PutMapping("/{codigoUbigeo}")
    public Ubigeo actualizarUbigeo(@PathVariable String codigoUbigeo, @RequestBody Ubigeo ubigeo) {
        return ubigeoService.actualizarUbigeo(codigoUbigeo, ubigeo);
    }

    @DeleteMapping("/{codigoUbigeo}")
    public void eliminarUbigeo(@PathVariable String codigoUbigeo) {
        ubigeoService.eliminarUbigeo(codigoUbigeo);
    }

    @GetMapping("/departamentos")
    public List<Ubigeo> getUbigeosWithEmptyOr00Values() {
        return ubigeoService.findUbigeosWithEmptyOr00Values();
    }

    @GetMapping("/provincia/{codigoDepartamento}")
    public List<Ubigeo> getUbigeosByCodigoProvinciaAndDistritoEmptyOr00(@PathVariable String codigoDepartamento) {
        return ubigeoService.findUbigeosByCodigoProvinciaAndDistritoEmptyOr00(codigoDepartamento);
    }

    @GetMapping("/distrito/{codigoDepartamento}/{codigoProvincia}")
    public List<Ubigeo> getUbigeosByCodigoDistrito(@PathVariable String codigoDepartamento, @PathVariable String codigoProvincia) {
        return ubigeoService.findUbigeosByCodigoDistrito(codigoProvincia, codigoDepartamento);
    }
}
