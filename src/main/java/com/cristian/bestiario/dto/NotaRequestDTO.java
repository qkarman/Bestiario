package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) para recibir solicitudes de creación o actualización de notas.
 * Se utiliza para capturar el contenido de la nota desde el cliente.
 * Campos:
 * - contenido: Texto de la nota que se desea crear o actualizar
 */
@Data
@NoArgsConstructor // Constructor vacío para frameworks y serialización
@AllArgsConstructor // Constructor con todos los campos
public class NotaRequestDTO
{
    private String contenido;
}
