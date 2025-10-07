package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) para transferir información de enemigos en la lista de favoritos.
 * Permite exponer los datos esenciales de un enemigo y su estado de favorito
 *
 * Campos:
 * - nombre: Nombre del enemigo
 * - vida: Puntos de vida del enemigo
 * - ataque: Puntos de ataque del enemigo
 * - favorito: Indica si el enemigo está marcado como favorito(true/false)
 */
@Data
@NoArgsConstructor // Constructor vacío para frameworks y serialización
@AllArgsConstructor // Constructor con todos los campos
public class FavoritosDTO
{
    private Integer idEnemigo;
    private String nombre;
    private Integer vida;
    private Integer ataque;
    private boolean favorito;
}
