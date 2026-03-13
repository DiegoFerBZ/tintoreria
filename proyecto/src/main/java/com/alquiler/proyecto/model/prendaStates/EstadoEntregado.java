package com.alquiler.proyecto.model.prendaStates;

import com.alquiler.proyecto.model.interfaces.IEstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

public class EstadoEntregado implements IEstadoPrenda {

    @Override
    public void alquilar(Prenda prenda) {
        throw new IllegalStateException("Debe lavarse primero");
    }

    @Override
    public void entregar(Prenda prenda) {
        throw new IllegalStateException("La prenda ya fue entregada");
    }

    @Override
    public void enviarALavado(Prenda prenda) {
        prenda.setEstado(EstadoPrenda.LAVADO);
    }

    @Override
    public void finalizarLavado(Prenda prenda) {
        throw new IllegalStateException("No está en lavado");
    }

    @Override
    public boolean estaDisponible() {
        return false;
    }
}
