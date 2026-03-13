package com.alquiler.proyecto.services.interfaces;

import com.alquiler.proyecto.dtos.request.CrearAlquilerDTO;
import com.alquiler.proyecto.dtos.response.AlquilerResponseDTO;

public interface IAlquilerService {
    AlquilerResponseDTO crearAlquiler(CrearAlquilerDTO dto);
}
