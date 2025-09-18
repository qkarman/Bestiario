package com.cristian.bestiario.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manejador global de excepciones para el sistema del bestiario
 * Esta clase captura excepciones lanzadas en los controladores y devuelve
 * respuestas HTTP adecuadas al cliente
 * Funcionalidad:
 * - Permite centralizar el manejo de errores y enviar mensajes claros
 * - Evita duplicar código de manejo de excepciones en cada controlador
 */
@RestControllerAdvice //Indica que esta clase maneja excepciones de manera global en controladores REST
public class GlobalExceptionHandler
{
    /**
     * Maneja la excepcion NotaNotFoundExcepcion
     * Se lanza cuando no se encuentra una nota específica en la base de datos
     * @param ex Excepcion lanzada
     * @return ResponseEntity con estado 404(NOT_FOUND) y mensaje de error
     */
    @ExceptionHandler(NotaNotFoundExcepcion.class)
    public ResponseEntity<String> handleNotaNotFound(NotaNotFoundExcepcion ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Maneja cualquier RuntimeExcepcion no controlada
     * Devuelve un estado HTTP 400 (BAD_REQUEST) y el mensaje de la excepcion
     * @param ex Excepcion lanzada
     * @return ResponseEntity con estado 400 (BAD_REQUEST) y mensaje de error
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
