package com.alquiler.proyecto.model.prendaStates;

import com.alquiler.proyecto.model.interfaces.IEstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

public class EstadoAlquilado implements IEstadoPrenda {

    @Override
    public void alquilar(Prenda prenda) {
        throw new IllegalStateException("La prenda ya está alquilada");
    }

    @Override
    public void entregar(Prenda prenda) {
        prenda.setEstado(EstadoPrenda.ENTREGADO);
    }

    @Override
    public void enviarALavado(Prenda prenda) {
        throw new IllegalStateException("Debe entregarse primero");
    }

    @Override
    public void finalizarLavado(Prenda prenda) {
        throw new IllegalStateException("La prenda no está en lavado");
    }

    @Override
    public boolean estaDisponible() {
        return false;
    }
}
