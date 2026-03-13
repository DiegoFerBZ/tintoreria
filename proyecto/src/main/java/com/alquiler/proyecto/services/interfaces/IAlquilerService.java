package com.alquiler.proyecto.services.interfaces;

import java.util.List;

import com.alquiler.proyecto.dtos.request.CrearAlquilerDTO;
import com.alquiler.proyecto.dtos.request.DevolverPrendaDTO;
import com.alquiler.proyecto.dtos.response.AlquilerResponseDTO;
import com.alquiler.proyecto.dtos.response.DevolucionResponseDTO;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;

public interface IAlquilerService {
    AlquilerResponseDTO crearAlquiler(CrearAlquilerDTO dto);
    DevolucionResponseDTO devolverPrenda(DevolverPrendaDTO dto);
    List<Prenda> obtenerPrendasParaLavar();
}
