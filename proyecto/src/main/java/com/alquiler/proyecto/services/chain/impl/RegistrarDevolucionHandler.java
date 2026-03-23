package com.alquiler.proyecto.services.chain.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.alquiler.proyecto.dtos.response.DevolucionResponseDTO;
import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.repositories.interfaces.IAlquilerRepository;
import com.alquiler.proyecto.services.chain.context.DevolucionContext;
import com.alquiler.proyecto.services.interfaces.IPrendaService;

import lombok.RequiredArgsConstructor;

/**
 * Chain of Responsibility — Paso 3: persiste la devolución y construye la respuesta.
 */
@Component
@RequiredArgsConstructor
public class RegistrarDevolucionHandler extends AbstractDevolucionHandler {

    private final IAlquilerRepository alquilerRepository;
    private final IPrendaService prendaService;

    @Override
    public void handle(DevolucionContext context) {
        Alquiler alquiler = context.getAlquiler();
        Prenda prenda = context.getPrenda();

        alquiler.setRequierePrioridadLavado(context.getDto().prioridad());
        alquiler.setFechaEntrega(LocalDate.now());
        alquilerRepository.save(alquiler);
        prendaService.actualizarInfoPrenda(prenda);

        context.setRespuesta(new DevolucionResponseDTO(
                prenda.getId(),
                prenda.getEstado(),
                alquiler.isRequierePrioridadLavado(),
                alquiler.getFechaEntrega()
        ));

        siguiente(context);
    }
}
