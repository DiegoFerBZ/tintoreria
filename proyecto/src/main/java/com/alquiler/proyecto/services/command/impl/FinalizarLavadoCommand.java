package com.alquiler.proyecto.services.command.impl;

import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.services.command.interfaces.PrendaCommand;

/**
 * Command: encapsula la finalización del proceso de lavado de una prenda.
 * Undo: revierte la prenda al estado LAVADO.
 */
public class FinalizarLavadoCommand implements PrendaCommand {

    private final Prenda prenda;

    public FinalizarLavadoCommand(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void execute() {
        prenda.finalizarLavado();
    }

    @Override
    public void undo() {
        prenda.setEstado(EstadoPrenda.LAVADO);
    }
}
