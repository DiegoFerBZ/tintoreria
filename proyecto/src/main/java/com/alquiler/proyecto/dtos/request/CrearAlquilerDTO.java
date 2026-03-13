package com.alquiler.proyecto.dtos.request;

public record CrearAlquilerDTO(
        Integer prendaId,
        Integer clienteId,
        Integer numeroDias
) {}
