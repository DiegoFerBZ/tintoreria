package com.alquiler.proyecto.model.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alquiler.proyecto.model.observer.interfaces.PrendaEstadoObserver;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

/**
 * Observer: detecta cuando una Prenda es entregada y la encola conceptualmente
 * para el proceso de lavado.
 */
public class LavadoQueueObserver implements PrendaEstadoObserver {

    private static final Logger log = LoggerFactory.getLogger(LavadoQueueObserver.class);

    @Override
    public void onEstadoCambiado(Prenda prenda, EstadoPrenda estadoAnterior, EstadoPrenda estadoNuevo) {
        if (EstadoPrenda.ENTREGADO.equals(estadoNuevo)) {
            log.info("[LAVADO-QUEUE] Prenda ID={} encolada para proceso de lavado.", prenda.getId());
        }
    }
}
