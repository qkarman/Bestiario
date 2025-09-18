package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) para transferir estadísticas básicas de un enemigo.
 * Se utiliza para exponer información resumida de vida y ataque sin enviar toda la entidad
 * Campos:
 * - nombre: Nombre del enemigo
 * - vida: Puntos de vida del enemigo
 * - ataque: Puntos de ataque del enemigo
 */
@Data
@NoArgsConstructor // Constructor vacío para frameworks y serialización
@AllArgsConstructor // Constructor con todos los campos
public class StatsDTO
{
    private String nombre;
    private Integer vida;
    private Integer ataque;
}
