package com.alquiler.proyecto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alquiler.proyecto.exceptions.ClienteNotFoundException;
import com.alquiler.proyecto.model.Cliente;
import com.alquiler.proyecto.repositories.interfaces.IClienteRepository;
import com.alquiler.proyecto.services.interfaces.IClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final IClienteRepository repository;

    @Override
    public List<Cliente> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente crear(Cliente c) {
        return repository.save(c);
    }

    @Override
    public Cliente obtenerPorId(Integer id) {
        return repository.findById(id)
                     .orElseThrow(() -> new ClienteNotFoundException(id));
    }
}
