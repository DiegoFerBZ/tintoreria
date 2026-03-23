package com.alquiler.proyecto.services.chain.impl;

import org.springframework.stereotype.Component;

import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.repositories.interfaces.IAlquilerRepository;
import com.alquiler.proyecto.services.chain.context.DevolucionContext;

import lombok.RequiredArgsConstructor;

/**
 * Chain of Responsibility — Paso 1: busca y valida que el alquiler exista.
 */
@Component
@RequiredArgsConstructor
public class BuscarAlquilerHandler extends AbstractDevolucionHandler {

    private final IAlquilerRepository alquilerRepository;

    @Override
    public void handle(DevolucionContext context) {
        Alquiler alquiler = alquilerRepository.findById(context.getDto().alquilerId())
                .orElseThrow(() -> new RuntimeException(
                        "Alquiler no encontrado con id " + context.getDto().alquilerId()));

        context.setAlquiler(alquiler);
        context.setPrenda(alquiler.getPrenda());
        siguiente(context);
    }
}
