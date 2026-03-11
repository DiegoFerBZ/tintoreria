package com.alquiler.proyecto.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alquiler.proyecto.model.Cliente;
import com.alquiler.proyecto.services.interfaces.IClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Clientes", description = "Operaciones relacionadas con clientes")
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService clienteService;

    @Operation(summary = "Obtener todos los clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.obtenerTodos();
        return ResponseEntity.ok(clientes);
    }

    // Obtener cliente por id
    @Operation(summary = "Obtener un cliente por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        Cliente c = clienteService.obtenerPorId(id);
        return ResponseEntity.ok(c);
    }

    @Operation(summary = "Crear un nuevo cliente")
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente c) {
        Cliente creado = clienteService.crear(c);
        return ResponseEntity.ok(creado);
    }

}
