package com.alquiler.proyecto.exceptions.global;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alquiler.proyecto.dtos.response.ApiResponse;

@RestControllerAdvice // Se aplica a todos los controllers REST
public class GlobalExceptionHandler {

    // Maneja tu excepción personalizada
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(NotFoundException ex) {
        ApiResponse<Object> response = new ApiResponse<>(
                null,
                LocalDateTime.now(),
                404,
                ex.getMessage());
        return ResponseEntity.status(404).body(response);
    }

    // Maneja excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception ex) {
        ApiResponse<Object> response = new ApiResponse<>(
                null,
                LocalDateTime.now(),
                500,
                "El sistema no puede responder la solicitud en el momento. Contacta con soporte");
        return ResponseEntity.status(500).body(response);
    }
}
