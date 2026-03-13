package com.alquiler.proyecto.config.ResponseWrapper;

import java.time.LocalDateTime;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alquiler.proyecto.dtos.response.global.ApiResponse;

@ControllerAdvice
public class ApiResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // No envolver respuestas de Swagger/OpenAPI
        String packageName = returnType.getContainingClass().getPackageName();
        if (packageName.startsWith("org.springdoc") || packageName.startsWith("springfox") ||
                packageName.startsWith("io.swagger")) {
            return false;
        }

        // Solo envolver si es de tus controladores
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {

        // Si ya es un ApiResponse, no lo envuelve de nuevo
        if (body instanceof ApiResponse) {
            return body;
        }
        int status = 200;
        if (response instanceof ServletServerHttpResponse servletResponse) {
            status = servletResponse.getServletResponse().getStatus();
        }

        // Envolver la respuesta en nuestro DTO genérico
        return new ApiResponse<>(
                body,
                LocalDateTime.now(),
                status,
                "OK");
    }
}
