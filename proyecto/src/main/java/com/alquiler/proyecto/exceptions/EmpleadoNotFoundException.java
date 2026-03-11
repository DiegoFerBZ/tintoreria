package com.alquiler.proyecto.exceptions;

import com.alquiler.proyecto.exceptions.global.NotFoundException;

public class EmpleadoNotFoundException extends NotFoundException {
    public EmpleadoNotFoundException(Integer id) {
        super("Empleado no encontrado con id " + id);
    }
}
