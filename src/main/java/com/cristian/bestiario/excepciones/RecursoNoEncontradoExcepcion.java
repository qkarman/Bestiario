package com.cristian.bestiario.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion personalizada que se lanza cuando un recurso solicitado no se encuentra en la base de datos
 * hereda de RuntimeExcepcion, por lo que es una excepcion no verificada
 * Anotación:
 * - @ResponseStatus(HttpStatus.NOT_FOUND): indica que cuando se lance esta excepcion, Spring
 * devolvera automáticamente un HTTP 404 (NOT_FOUND) al cliente
 * Uso:
 * - Se utiliza en los servicios o controladores para indicar que un recurso (enemigo, nota, etc.)
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoExcepcion extends RuntimeException
{
    /**
     * Constructor que recibe un mensaje descriptivo del error
     * @param mensaje Mensaje que describe la causa de la excepcion
     */
    public RecursoNoEncontradoExcepcion(String mensaje)
    {
        super(mensaje);
    }
}
