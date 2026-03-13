package com.alquiler.proyecto.model;

import java.time.LocalDate;

import com.alquiler.proyecto.model.prendas.Prenda;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prenda_id", nullable = false)
    private Prenda prenda; 

    private LocalDate fechaAlquiler;

    private Integer numeroDias;
}