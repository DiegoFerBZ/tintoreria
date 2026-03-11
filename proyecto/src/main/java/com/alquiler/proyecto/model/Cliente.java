package com.alquiler.proyecto.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona {

    private String mail;
}
