package com.alquiler.proyecto.dtos.request;

import com.alquiler.proyecto.model.prendas.enums.TipoPrenda;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public record CrearPrendaDTO(
    TipoPrenda tipo,
    String referencia,
    Double valorAlquiler,
    Boolean pedreria,
    String altura,
    Integer cantPiezas,
    String aderezo,
    String tipoTraje,
    String nombre
) {}