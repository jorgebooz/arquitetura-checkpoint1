package com.fiap.lojaonline.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 - Recurso não encontrado
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> handleRecursoNaoEncontrado(
            RecursoNaoEncontradoException ex,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao err = new ErroPadrao(
                Instant.now(),
                status.value(),
                "Not Found",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }

    // 400 - Conflito de negócio (ex: email já cadastrado, nome duplicado)
    @ExceptionHandler(ConflitoNegocioException.class)
    public ResponseEntity<ErroPadrao> handleConflitoNegocio(
            ConflitoNegocioException ex,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao err = new ErroPadrao(
                Instant.now(),
                status.value(),
                "Bad Request",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }

    // 500 - Qualquer outro erro não tratado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroPadrao> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErroPadrao err = new ErroPadrao(
                Instant.now(),
                status.value(),
                "Internal Server Error",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }
}
