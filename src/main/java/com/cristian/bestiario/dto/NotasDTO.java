package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) para exponer información de notas de manera limpia y controlada.
 * Se utiliza cuando se necesita mostrar solo los datos relevantes de una nota al acceder a ellas
 * Campos:
 * - idNotas: Identificador unico de la nota
 * = usuario: Nombre del usuario que creo la nota
 * - enemigo: Nombre del enemigo al que esta asociada la nota
 * - contenido: Texto de la nota
 */
@Data
@NoArgsConstructor // Constructor vacío para frameworks y serialización
@AllArgsConstructor // Constructor con todos los campos
public class NotasDTO
{
    private Integer idNotas;
    private String usuario;
    private String enemigo;
    private String contenido;
}
