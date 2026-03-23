package com.alquiler.proyecto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alquiler.proyecto.services.chain.impl.BuscarAlquilerHandler;
import com.alquiler.proyecto.services.chain.impl.CambiarEstadoPrendaHandler;
import com.alquiler.proyecto.services.chain.impl.RegistrarDevolucionHandler;
import com.alquiler.proyecto.services.chain.interfaces.DevolucionHandler;

/**
 * Ensambla la cadena de responsabilidad para el flujo de devolución de prendas:
 *
 *   BuscarAlquilerHandler
 *     → CambiarEstadoPrendaHandler  (usa Command internamente)
 *       → RegistrarDevolucionHandler
 */
@Configuration
public class DevolucionChainConfig {

    @Bean
    public DevolucionHandler devolucionChain(
            BuscarAlquilerHandler buscarAlquilerHandler,
            CambiarEstadoPrendaHandler cambiarEstadoPrendaHandler,
            RegistrarDevolucionHandler registrarDevolucionHandler) {

        buscarAlquilerHandler.setNext(cambiarEstadoPrendaHandler);
        cambiarEstadoPrendaHandler.setNext(registrarDevolucionHandler);
        return buscarAlquilerHandler;
    }
}
