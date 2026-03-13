package com.alquiler.proyecto.exceptions.global;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alquiler.proyecto.dtos.response.global.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(NotFoundException ex) {
        ApiResponse<Object> response = new ApiResponse<>(null, LocalDateTime.now(), 404, ex.getMessage());
        return ResponseEntity.status(404)
                .header("Content-Type", "application/json")
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception ex) {
        ApiResponse<Object> response = new ApiResponse<>(null, LocalDateTime.now(), 500,
                "El sistema no puede responder la solicitud en el momento. Contacta con soporte");
        System.out.println(ex.getMessage());
        return ResponseEntity.status(500)
                .header("Content-Type", "application/json")
                .body(response);
    }
}
