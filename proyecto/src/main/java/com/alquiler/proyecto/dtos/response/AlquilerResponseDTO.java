package com.alquiler.proyecto.dtos.response;

import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;

public record AlquilerResponseDTO(
        Integer prendaId,
        EstadoPrenda estado,
        Integer clienteId
) {}
