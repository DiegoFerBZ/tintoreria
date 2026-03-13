package com.alquiler.proyecto.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alquiler.proyecto.dtos.request.CrearAlquilerDTO;
import com.alquiler.proyecto.dtos.request.DevolverPrendaDTO;
import com.alquiler.proyecto.dtos.response.AlquilerResponseDTO;
import com.alquiler.proyecto.dtos.response.DevolucionResponseDTO;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.services.interfaces.IAlquilerService;
import com.alquiler.proyecto.services.strategy.lavado.impl.PrendasPorPrioridadYFechaStrategy;

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

    @PatchMapping("/devolver")
    public ResponseEntity<DevolucionResponseDTO> devolverPrenda(@RequestBody DevolverPrendaDTO dto) {
        DevolucionResponseDTO response = service.devolverPrenda(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/lavar")
        public ResponseEntity<List<Prenda>> obtenerPrendasParaLavar() {

            List<Prenda> lista = service.obtenerPrendasParaLavar();
            return ResponseEntity.ok(lista);
        }

}
