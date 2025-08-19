package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Creamos el nombre, description y tipo
public class DescripcionDTO
{
    private String nombre;
    private String tipo;
    private String descripcion;
}
