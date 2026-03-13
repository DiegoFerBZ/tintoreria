package com.alquiler.proyecto.dtos.request;

import java.time.LocalDate;

public record DevolverPrendaDTO(
        Integer alquilerId,      
        boolean prioridad     
) {}
