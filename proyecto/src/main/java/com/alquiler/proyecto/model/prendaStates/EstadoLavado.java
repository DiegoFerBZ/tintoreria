package com.alquiler.proyecto.model.prendaStates;

import com.alquiler.proyecto.model.interfaces.IEstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

public class EstadoLavado implements IEstadoPrenda {

    @Override
    public void alquilar(Prenda prenda) {
        throw new IllegalStateException("La prenda está en lavado");
    }

    @Override
    public void entregar(Prenda prenda) {
        throw new IllegalStateException("No está alquilada");
    }

    @Override
    public void enviarALavado(Prenda prenda) {
        throw new IllegalStateException("Ya está en lavado");
    }

    @Override
    public void finalizarLavado(Prenda prenda) {
        prenda.setEstado(EstadoPrenda.DISPONIBLE);
    }

    @Override
    public boolean estaDisponible() {
        return false;
    }
}
