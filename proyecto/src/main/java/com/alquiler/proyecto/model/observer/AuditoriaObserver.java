package com.alquiler.proyecto.model.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alquiler.proyecto.model.observer.interfaces.PrendaEstadoObserver;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

/**
 * Observer: registra en el log cada transición de estado de una Prenda.
 */
public class AuditoriaObserver implements PrendaEstadoObserver {

    private static final Logger log = LoggerFactory.getLogger(AuditoriaObserver.class);

    @Override
    public void onEstadoCambiado(Prenda prenda, EstadoPrenda estadoAnterior, EstadoPrenda estadoNuevo) {
        log.info("[AUDITORIA] Prenda ID={} | Referencia='{}' | {} → {}",
                prenda.getId(), prenda.getReferencia(), estadoAnterior, estadoNuevo);
    }
}
