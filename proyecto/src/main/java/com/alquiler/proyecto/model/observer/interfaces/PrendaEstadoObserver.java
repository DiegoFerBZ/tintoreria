package com.alquiler.proyecto.model.observer.interfaces;

import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

/**
 * Observer: contrato para reaccionar a cambios de estado de una Prenda.
 */
public interface PrendaEstadoObserver {
    void onEstadoCambiado(Prenda prenda, EstadoPrenda estadoAnterior, EstadoPrenda estadoNuevo);
}
