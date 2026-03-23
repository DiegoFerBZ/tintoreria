package com.alquiler.proyecto.services.command.impl;

import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.services.command.interfaces.PrendaCommand;

/**
 * Command: encapsula la operación de devolver una prenda (entrega del cliente).
 * Undo: revierte la prenda al estado ALQUILADO.
 */
public class DevolverPrendaCommand implements PrendaCommand {

    private final Prenda prenda;

    public DevolverPrendaCommand(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void execute() {
        prenda.entregar();
    }

    @Override
    public void undo() {
        prenda.setEstado(EstadoPrenda.ALQUILADO);
    }
}
