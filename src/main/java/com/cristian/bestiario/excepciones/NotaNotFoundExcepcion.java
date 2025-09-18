package com.cristian.bestiario.excepciones;

/**
 * Excepcion personalizada que se lanza cuando no se encuentra una nota específica en la base de datos
 * Uso:
 * - Se utiliza en el servicio o controlador para indicar que la nota solicitada no existe.
 * - El GlobalExceptionHandler captura esta excepción y devuelve un HTTP 404 al cliente.
 */
public class NotaNotFoundExcepcion extends RuntimeException
{
    /**
     * Constructor que recibe un mensaje descriptivo del error.
     *
     * @param mensaje Mensaje que describe la causa de la excepción
     */
    public NotaNotFoundExcepcion(String mensaje)
    {
        super(mensaje);
    }
}
