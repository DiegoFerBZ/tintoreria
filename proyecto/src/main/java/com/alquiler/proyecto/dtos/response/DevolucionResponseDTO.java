package com.alquiler.proyecto.dtos.response;

import java.time.LocalDate;

import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;

public record DevolucionResponseDTO(
        Integer prendaId,
        EstadoPrenda estado,
        boolean prioridad,
        LocalDate fechaEntrega
) {}
