package com.example.SpringBoot.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase que maneja excepciones globales en los controladores REST.
 * Utiliza la anotación @RestControllerAdvice para aplicar el manejo de excepciones a todos los controladores.
 */
@RestControllerAdvice
public class RutasHandler {
    private final Logger logger = LoggerFactory.getLogger(RutasHandler.class);

    /**
     * Maneja excepciones de tipo NullPointerException.
     *
     * @param exception La excepción capturada.
     * @return Un mensaje de error.
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerNullPointer(NullPointerException exception) {
        logger.error(exception.getMessage());
        return "Internal error. Contact support";
    }
}