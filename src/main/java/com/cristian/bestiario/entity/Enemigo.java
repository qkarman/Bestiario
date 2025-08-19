package com.cristian.bestiario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

//Creamos todas las anotaciones de lombok
@Entity //Esta annotation representa una tabla en la base de datos
@Data //Lombok genera automáticamente getters, setters, toString, equals y hashcode
@NoArgsConstructor //Lombok genera un constructor vació(sin parameters)
@AllArgsConstructor //Lombok genera un constructor con todos los campos de la clase
public class Enemigo
{
    //Anotacion que actua como clave primaria en la base de datos
    @Id
    //Indica que el valor de ID se genera automáticamente(Auto-incremental)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEnemigo;
    String nombre;
    String tipo;
    Integer vida;
    Integer ataque;
    String habilidad;
    String descripcion;
    Boolean favorito;
    String notas;

    //Creamos la lista de guardado y el many es para indicar una relacion de muchos a muchos entre entidad de
    //enemigo y usuario
    @ManyToMany(mappedBy = "favoritos")
    private Set<Usuario> usuariosFavoritos = new HashSet<>();
}
