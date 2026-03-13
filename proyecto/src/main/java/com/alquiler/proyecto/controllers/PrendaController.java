package com.alquiler.proyecto.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alquiler.proyecto.dtos.request.CrearPrendaDTO;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.services.interfaces.IPrendaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Prendas", description = "Operaciones relacionadas con prendas")
@RestController
@RequestMapping("/api/prendas")
@RequiredArgsConstructor
public class PrendaController {
    private final IPrendaService servicio;

    @PostMapping
    public Prenda crear(@RequestBody CrearPrendaDTO dto) {
        return servicio.crear(dto);

    }

    @GetMapping
    public ResponseEntity<List<Prenda>> getAll() {
        List<Prenda> prendas = servicio.obtenerTodas();
        return ResponseEntity.ok(prendas);
    }
}
