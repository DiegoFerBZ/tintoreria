package com.alquiler.proyecto.services.chain.interfaces;

import com.alquiler.proyecto.services.chain.context.DevolucionContext;

/**
 * Chain of Responsibility: contrato de cada eslabón de la cadena de devolución.
 */
public interface DevolucionHandler {
    void setNext(DevolucionHandler next);
    void handle(DevolucionContext context);
}
