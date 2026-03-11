package com.alquiler.proyecto.exceptions;

import com.alquiler.proyecto.exceptions.global.NotFoundException;

public class ClienteNotFoundException extends NotFoundException {
    public ClienteNotFoundException(Integer id) {
        super("Cliente no encontrado con id " + id);
    }
}


