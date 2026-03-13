package com.alquiler.proyecto.model.prendaStates;

import com.alquiler.proyecto.exceptions.StatePrendaException;
import com.alquiler.proyecto.model.interfaces.IEstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

public class EstadoDisponible implements IEstadoPrenda  {
    @Override
    public void alquilar(Prenda prenda) {
        prenda.setEstado(EstadoPrenda.ALQUILADO);
    }

    @Override
    public void entregar(Prenda prenda) {
        throw new StatePrendaException("La prenda no está alquilada");
    }

    @Override
    public void enviarALavado(Prenda prenda) {
        throw new StatePrendaException("No se puede lavar si no ha sido usada");
    }

    @Override
    public void finalizarLavado(Prenda prenda) {
        throw new StatePrendaException("La prenda no está en lavado");
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }
}
