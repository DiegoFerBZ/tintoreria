package com.alquiler.proyecto.exceptions;

import com.alquiler.proyecto.exceptions.global.NotFoundException;

public class PrendaNotFoundException extends NotFoundException {

    public PrendaNotFoundException(int id) {
        super("Prenda no encontrada con id " + id);
    }

}
