package com.alquiler.proyecto.model.prendaStates;

import com.alquiler.proyecto.model.interfaces.IEstadoPrenda;

public class EstadoPrendaFactory {
    public static IEstadoPrenda crear(EstadoPrenda estado) {

        return switch (estado) {
            case DISPONIBLE -> new EstadoDisponible();
            case ALQUILADO -> new EstadoAlquilado();
            case ENTREGADO -> new EstadoEntregado();
            case LAVADO -> new EstadoLavado();
        };
    }
}
