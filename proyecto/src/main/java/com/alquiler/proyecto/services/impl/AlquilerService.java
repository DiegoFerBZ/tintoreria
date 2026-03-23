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
import com.alquiler.proyecto.services.chain.context.DevolucionContext;
import com.alquiler.proyecto.services.chain.interfaces.DevolucionHandler;
import com.alquiler.proyecto.services.command.PrendaCommandInvoker;
import com.alquiler.proyecto.services.command.impl.AlquilarPrendaCommand;
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
    private final DevolucionHandler devolucionChain;
    private final PrendaCommandInvoker commandInvoker;
    private PrendaLimpiezaStrategy estrategia = new PrendasPorPrioridadYFechaStrategy();

    @Override
    public AlquilerResponseDTO crearAlquiler(CrearAlquilerDTO dto) {
        Prenda prenda = prendaService.obtenerPorId(dto.prendaId());

        // Command: encapsula la transición DISPONIBLE → ALQUILADO con soporte de undo
        commandInvoker.ejecutar(new AlquilarPrendaCommand(prenda));
        prendaService.actualizarInfoPrenda(prenda);

        Alquiler alquiler = new Alquiler();
        alquiler.setPrenda(prenda);
        alquiler.setCliente(clienteService.obtenerPorId(dto.clienteId()));
        alquiler.setFechaAlquiler(LocalDate.now());
        alquiler.setNumeroDias(dto.numeroDias());
        alquilerRepository.save(alquiler);

        return new AlquilerResponseDTO(prenda.getId(), prenda.getEstado(), alquiler.getCliente().getId());
    }

    @Override
    @Transactional
    public DevolucionResponseDTO devolverPrenda(DevolverPrendaDTO dto) {
        // Chain of Responsibility: cada handler tiene una única responsabilidad
        DevolucionContext context = new DevolucionContext(dto);
        devolucionChain.handle(context);
        return context.getRespuesta();
    }

    @Override
    public List<Prenda> obtenerPrendasParaLavar() {
        List<Alquiler> alquileresEntregados = alquilerRepository.findByPrendaEstado(EstadoPrenda.ENTREGADO);
        return estrategia.obtenerPrendas(alquileresEntregados);
    }
}
