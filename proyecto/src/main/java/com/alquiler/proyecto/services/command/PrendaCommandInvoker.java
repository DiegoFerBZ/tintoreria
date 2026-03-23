package com.alquiler.proyecto.services.command;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alquiler.proyecto.services.command.interfaces.PrendaCommand;

/**
 * Command — Invoker: ejecuta comandos y mantiene un historial que permite
 * deshacer la última operación realizada sobre una Prenda.
 */
@Component
public class PrendaCommandInvoker {

    private static final Logger log = LoggerFactory.getLogger(PrendaCommandInvoker.class);

    private final Deque<PrendaCommand> historial = new ArrayDeque<>();

    public void ejecutar(PrendaCommand command) {
        command.execute();
        historial.push(command);
        log.info("[COMMAND] Ejecutado: {}", command.getClass().getSimpleName());
    }

    public void deshacerUltimo() {
        if (!historial.isEmpty()) {
            PrendaCommand command = historial.pop();
            command.undo();
            log.info("[COMMAND] Deshecho: {}", command.getClass().getSimpleName());
        } else {
            log.warn("[COMMAND] No hay operaciones en el historial para deshacer.");
        }
    }

    public int tamañoHistorial() {
        return historial.size();
    }
}
