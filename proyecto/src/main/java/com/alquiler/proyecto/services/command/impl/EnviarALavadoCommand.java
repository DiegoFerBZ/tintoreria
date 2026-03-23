package com.alquiler.proyecto.services.command.impl;

import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.services.command.interfaces.PrendaCommand;

/**
 * Command: encapsula el envío de una prenda al proceso de lavado.
 * Undo: revierte la prenda al estado ENTREGADO.
 */
public class EnviarALavadoCommand implements PrendaCommand {

    private final Prenda prenda;

    public EnviarALavadoCommand(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void execute() {
        prenda.enviarALavado();
    }

    @Override
    public void undo() {
        prenda.setEstado(EstadoPrenda.ENTREGADO);
    }
}
