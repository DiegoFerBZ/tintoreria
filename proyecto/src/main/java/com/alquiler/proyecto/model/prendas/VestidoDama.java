package com.alquiler.proyecto.model.prendas;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VestidoDama extends Prenda {

    private boolean pedreria;
    private String altura;
    private int cantPiezas;

    public VestidoDama(String referencia, double valorAlquiler) {
        super(referencia, valorAlquiler);
    }
}
