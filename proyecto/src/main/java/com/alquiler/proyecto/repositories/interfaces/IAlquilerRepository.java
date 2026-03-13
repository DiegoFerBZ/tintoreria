package com.alquiler.proyecto.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alquiler.proyecto.model.Alquiler;

@Repository
public interface IAlquilerRepository extends JpaRepository<Alquiler, Integer>{

}
