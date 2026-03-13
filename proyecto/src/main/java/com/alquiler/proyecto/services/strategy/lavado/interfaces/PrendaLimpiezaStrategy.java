package com.alquiler.proyecto.services.strategy.lavado.interfaces;

import java.util.List;

import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.model.prendas.Prenda;

public interface PrendaLimpiezaStrategy {
    List<Prenda> obtenerPrendas(List<Alquiler> prendas);
}
