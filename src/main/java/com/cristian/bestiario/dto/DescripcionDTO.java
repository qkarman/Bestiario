package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) para transferir información de la descripcion de un enemigo
 * Se utiliza para exponer datos relevantes sin enviar toda la entidad completa
 *
 * Campos:
 * - nombre: Nombre del enemigo
 * _ tipo: Tipo o categoria del enemigo (ej. "Orco", "Dragon")
 * - descripcion: Breve descripcion del enemigo
 */
@Data
@NoArgsConstructor // Constructor vació para frameworks y serializacion
@AllArgsConstructor //Constructor con todos los campos
//Creamos el nombre, description y tipo
public class DescripcionDTO
{
    private String nombre;
    private String tipo;
    private String descripcion;
}
