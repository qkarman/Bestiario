package com.cristian.bestiario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Esta clase crea la relacion: cada nota pertenece a un usuario y a un enemigo
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nota
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_enemigo")
    private Enemigo enemigo;

    @Column(length = 1000) // para que el texto pueda ser largo
    private String contenido;
}
