package com.alquiler.proyecto.model.prendas;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Disfraz extends Prenda {

    private String nombre;

    public Disfraz(String referencia, double valorAlquiler) {
        super(referencia, valorAlquiler);
    }
}
