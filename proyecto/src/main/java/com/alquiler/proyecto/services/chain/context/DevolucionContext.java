package com.alquiler.proyecto.services.chain.context;

import com.alquiler.proyecto.dtos.request.DevolverPrendaDTO;
import com.alquiler.proyecto.dtos.response.DevolucionResponseDTO;
import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.model.prendas.Prenda;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Chain of Responsibility: objeto de contexto que viaja a lo largo de la cadena
 * de devolución, siendo enriquecido por cada handler.
 */
@Data
@RequiredArgsConstructor
public class DevolucionContext {
    private final DevolverPrendaDTO dto;
    private Alquiler alquiler;
    private Prenda prenda;
    private DevolucionResponseDTO respuesta;
}
