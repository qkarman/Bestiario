package com.cristian.bestiario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Aquí vamos a crear una visualization más limpia que muestre solo lo que necesitamos cuando accedes a notas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotasDTO
{
    private Integer idNotas;
    private String usuario;
    private String enemigo;
    private String contenido;
}
