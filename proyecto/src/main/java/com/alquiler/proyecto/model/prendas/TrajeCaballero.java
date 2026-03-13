package com.alquiler.proyecto.model.prendas;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TrajeCaballero extends Prenda {

    private String tipo;
    private String aderezo;

    public TrajeCaballero(String referencia, double valorAlquiler) {
        super(referencia, valorAlquiler);
    }
}
