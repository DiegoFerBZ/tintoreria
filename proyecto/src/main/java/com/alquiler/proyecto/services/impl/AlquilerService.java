package com.alquiler.proyecto.services.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.alquiler.proyecto.dtos.request.CrearAlquilerDTO;
import com.alquiler.proyecto.dtos.response.AlquilerResponseDTO;
import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.repositories.interfaces.IAlquilerRepository;
import com.alquiler.proyecto.services.interfaces.IAlquilerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlquilerService implements IAlquilerService {

    private final IAlquilerRepository alquilerRepository;
    private final PrendaService prendaService;
    private final ClienteService clienteService;

    @Override
    public AlquilerResponseDTO crearAlquiler(CrearAlquilerDTO dto) {
        // 1. Buscar la prenda
        Prenda prenda = prendaService.obtenerPorId(dto.prendaId());

        // 2. Actualizar el estado de la prenda (por ejemplo: ALQUILADA)
        prenda.setEstado(EstadoPrenda.ALQUILADO);
        prendaService.actualizarInfoPrenda(prenda);

        // 3. Crear registro de alquiler si necesitas
        Alquiler alquiler = new Alquiler();
        alquiler.setPrenda(prenda);
        alquiler.setCliente(clienteService.obtenerPorId(dto.clienteId()));
        alquiler.setFechaAlquiler(LocalDate.now());
        alquiler.setNumeroDias(dto.numeroDias());

        alquilerRepository.save(alquiler);

        // 4. Retornar DTO con información resumida
        return new AlquilerResponseDTO(prenda.getId(), prenda.getEstado(), alquiler.getCliente().getId());
    }

}
