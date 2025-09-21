package com.fiap.lojaonline.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // 400 - Validação de dados inválidos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidacao(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


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

    // 409 - Conflito de negócio (CORRETO)
    @ExceptionHandler(ConflitoNegocioException.class)
    public ResponseEntity<ErroPadrao> handleConflitoNegocio(
            ConflitoNegocioException ex,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.CONFLICT; // ← CORRIGIDO
        ErroPadrao err = new ErroPadrao(
                Instant.now(),
                status.value(),
                "Conflict", // ← Atualize também a mensagem
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
