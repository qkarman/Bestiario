package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoritosDTO
{
    private String nombre;
    private Integer vida;
    private Integer ataque;
    private boolean favorito;
}
