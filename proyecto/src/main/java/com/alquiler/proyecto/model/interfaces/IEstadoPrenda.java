package com.alquiler.proyecto.model.interfaces;

import com.alquiler.proyecto.model.prendas.Prenda;

public interface IEstadoPrenda {
    void alquilar(Prenda prenda);

    void entregar(Prenda prenda);

    void enviarALavado(Prenda prenda);

    void finalizarLavado(Prenda prenda);

    boolean estaDisponible();
}
