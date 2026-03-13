package com.alquiler.proyecto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alquiler.proyecto.dtos.request.CrearAlquilerDTO;
import com.alquiler.proyecto.dtos.response.AlquilerResponseDTO;
import com.alquiler.proyecto.services.interfaces.IAlquilerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Alquiler", description = "Operaciones relacionadas con alquiler de prendas")
@RestController
@RequestMapping("/api/alquiler")
@RequiredArgsConstructor
public class AlquilerController {

    private final IAlquilerService service;

    @PostMapping
    public ResponseEntity<AlquilerResponseDTO> crearAlquiler(@RequestBody CrearAlquilerDTO dto) {
        AlquilerResponseDTO response = service.crearAlquiler(dto);
        return ResponseEntity.ok(response);
    }

}
