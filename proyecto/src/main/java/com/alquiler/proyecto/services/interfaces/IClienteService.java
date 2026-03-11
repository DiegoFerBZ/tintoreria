package com.alquiler.proyecto.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.alquiler.proyecto.model.Cliente;

public interface IClienteService {
    List<Cliente> obtenerTodos();
    Cliente crear(Cliente c);
    Cliente obtenerPorId(Integer id); 
}
