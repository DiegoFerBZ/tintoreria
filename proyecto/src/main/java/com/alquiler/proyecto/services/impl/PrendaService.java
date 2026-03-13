package com.alquiler.proyecto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alquiler.proyecto.dtos.request.CrearPrendaDTO;
import com.alquiler.proyecto.exceptions.PrendaNotFoundException;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.model.prendas.factory.PrendaFactory;
import com.alquiler.proyecto.repositories.interfaces.IPrendaRepository;
import com.alquiler.proyecto.services.interfaces.IPrendaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrendaService implements IPrendaService{

    private final IPrendaRepository repository;

    @Override
    public Prenda crear(CrearPrendaDTO dto) {
        Prenda prenda = PrendaFactory.crear(dto);

        return repository.save(prenda);
    }

    @Override
    public List<Prenda> obtenerTodas() {
        return repository.findAll();
    }
    
    @Override
    public Prenda obtenerPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new PrendaNotFoundException(id));
    }

    @Override
    public Prenda actualizarInfoPrenda(Prenda prenda) {
        return repository.save(prenda);
    }

}
