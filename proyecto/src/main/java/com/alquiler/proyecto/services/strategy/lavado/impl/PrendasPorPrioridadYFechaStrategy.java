package com.alquiler.proyecto.services.strategy.lavado.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.services.strategy.lavado.interfaces.PrendaLimpiezaStrategy;

public class PrendasPorPrioridadYFechaStrategy implements PrendaLimpiezaStrategy {

    @Override
    public List<Prenda> obtenerPrendas(List<Alquiler> alquileres) {
        return alquileres.stream()
                .filter(a -> a.getFechaEntrega() != null)
                .sorted(Comparator
                        .<Alquiler, Boolean>comparing(a -> a.isRequierePrioridadLavado(), Comparator.reverseOrder())
                        .thenComparing(Alquiler::getFechaEntrega))
                .map(Alquiler::getPrenda)
                .toList();
    }
}