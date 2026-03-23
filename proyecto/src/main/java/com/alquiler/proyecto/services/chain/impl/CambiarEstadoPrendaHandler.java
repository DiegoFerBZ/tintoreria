package com.alquiler.proyecto.services.chain.impl;

import org.springframework.stereotype.Component;

import com.alquiler.proyecto.services.chain.context.DevolucionContext;
import com.alquiler.proyecto.services.command.PrendaCommandInvoker;
import com.alquiler.proyecto.services.command.impl.DevolverPrendaCommand;

import lombok.RequiredArgsConstructor;

/**
 * Chain of Responsibility — Paso 2: ejecuta la transición de estado de la Prenda
 * delegando en el Command pattern (DevolverPrendaCommand).
 */
@Component
@RequiredArgsConstructor
public class CambiarEstadoPrendaHandler extends AbstractDevolucionHandler {

    private final PrendaCommandInvoker commandInvoker;

    @Override
    public void handle(DevolucionContext context) {
        commandInvoker.ejecutar(new DevolverPrendaCommand(context.getPrenda()));
        siguiente(context);
    }
}
