package com.alquiler.proyecto.services.interfaces;

import java.util.List;

import com.alquiler.proyecto.dtos.request.CrearPrendaDTO;
import com.alquiler.proyecto.model.prendas.Prenda;

public interface IPrendaService {
    Prenda crear(CrearPrendaDTO dto);
    List<Prenda> obtenerTodas();
    Prenda obtenerPorId(int id);
    
}
