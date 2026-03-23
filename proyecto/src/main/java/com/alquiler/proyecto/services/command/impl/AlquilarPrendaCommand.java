package com.alquiler.proyecto.services.command.impl;

import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.services.command.interfaces.PrendaCommand;

/**
 * Command: encapsula la operación de alquilar una prenda.
 * Undo: revierte la prenda al estado DISPONIBLE.
 */
public class AlquilarPrendaCommand implements PrendaCommand {

    private final Prenda prenda;

    public AlquilarPrendaCommand(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void execute() {
        prenda.alquilar();
    }

    @Override
    public void undo() {
        prenda.setEstado(EstadoPrenda.DISPONIBLE);
    }
}
