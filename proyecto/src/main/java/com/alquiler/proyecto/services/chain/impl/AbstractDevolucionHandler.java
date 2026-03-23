package com.alquiler.proyecto.services.chain.impl;

import com.alquiler.proyecto.services.chain.context.DevolucionContext;
import com.alquiler.proyecto.services.chain.interfaces.DevolucionHandler;

/**
 * Chain of Responsibility: base abstracta que gestiona el encadenamiento
 * y la delegación al siguiente handler.
 */
public abstract class AbstractDevolucionHandler implements DevolucionHandler {

    private DevolucionHandler next;

    @Override
    public void setNext(DevolucionHandler next) {
        this.next = next;
    }

    protected void siguiente(DevolucionContext context) {
        if (next != null) {
            next.handle(context);
        }
    }
}
