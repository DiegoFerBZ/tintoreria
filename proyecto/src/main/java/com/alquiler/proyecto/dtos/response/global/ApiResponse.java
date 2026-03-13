package com.alquiler.proyecto.dtos.response.global;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        T data,
        LocalDateTime timestamp,
        int status,
        String message
) {}
