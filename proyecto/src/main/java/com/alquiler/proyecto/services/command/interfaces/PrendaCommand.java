package com.alquiler.proyecto.services.command.interfaces;

/**
 * Command: contrato para encapsular una operación sobre una Prenda,
 * incluyendo su operación inversa (undo).
 */
public interface PrendaCommand {
    void execute();
    void undo();
}
