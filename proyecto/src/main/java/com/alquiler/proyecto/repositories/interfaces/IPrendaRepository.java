package com.alquiler.proyecto.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alquiler.proyecto.model.prendas.Prenda;

public interface IPrendaRepository extends JpaRepository<Prenda, Integer> {
}
