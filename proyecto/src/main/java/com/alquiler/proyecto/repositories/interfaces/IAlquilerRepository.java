package com.alquiler.proyecto.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alquiler.proyecto.model.Alquiler;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;

@Repository
public interface IAlquilerRepository extends JpaRepository<Alquiler, Integer>{
    @EntityGraph(attributePaths = {"prenda", "cliente"})
    List<Alquiler> findByPrendaEstado(EstadoPrenda estado);
}
