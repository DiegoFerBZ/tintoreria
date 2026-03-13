package com.alquiler.proyecto.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alquiler.proyecto.dtos.request.CrearAlquilerDTO;
import com.alquiler.proyecto.dtos.request.DevolverPrendaDTO;
import com.alquiler.proyecto.dtos.response.AlquilerResponseDTO;
import com.alquiler.proyecto.dtos.response.DevolucionResponseDTO;
import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.repositories.interfaces.IAlquilerRepository;
import com.alquiler.proyecto.services.interfaces.IAlquilerService;
import com.alquiler.proyecto.services.strategy.lavado.impl.PrendasPorPrioridadYFechaStrategy;
import com.alquiler.proyecto.services.strategy.lavado.interfaces.PrendaLimpiezaStrategy;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlquilerService implements IAlquilerService {

    private final IAlquilerRepository alquilerRepository;
    private final PrendaService prendaService;
    private final ClienteService clienteService;
    private PrendaLimpiezaStrategy estrategia = new PrendasPorPrioridadYFechaStrategy(); 

    @Override
    public AlquilerResponseDTO crearAlquiler(CrearAlquilerDTO dto) {
        // 1. Buscar la prenda
        Prenda prenda = prendaService.obtenerPorId(dto.prendaId());

        // 2. Actualizar el estado de la prenda (por ejemplo: ALQUILADA)
        prenda.alquilar();
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

    @Override
    @Transactional
    public DevolucionResponseDTO devolverPrenda(DevolverPrendaDTO dto) {

        Alquiler alquiler = alquilerRepository.findById(dto.alquilerId())
                .orElseThrow(() -> new RuntimeException("Alquiler no encontrado con id " + dto.alquilerId()));

        Prenda prenda = alquiler.getPrenda();
        prenda.entregar();
        prenda.setEstado(EstadoPrenda.ENTREGADO);
        prendaService.actualizarInfoPrenda(prenda); 

        alquiler.setRequierePrioridadLavado(dto.prioridad());
        alquiler.setFechaEntrega(LocalDate.now());

        alquilerRepository.save(alquiler);

        return new DevolucionResponseDTO(
                prenda.getId(),
                prenda.getEstado(),
                alquiler.isRequierePrioridadLavado(),
                alquiler.getFechaEntrega()
        );
    }


    @Override
    public List<Prenda> obtenerPrendasParaLavar() {
        List<Alquiler> alquileresEntregados = alquilerRepository.findByPrendaEstado(EstadoPrenda.ENTREGADO);

        return estrategia.obtenerPrendas(alquileresEntregados);
    }

}
