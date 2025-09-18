package com.cristian.bestiario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un enemigo en la base de datos
 * Se mapea a una tabla mediante JPA y se utiliza en las operaciones CRUD del sistema
 * Campos:
 * - idEnemigo: Identificador unico del enemigo(clave primaria, auto-incremental)
 * - nombre: Nombre del enemigo
 * - tipo: Tipo o categoria del enemigo (ej. "Orco", "Dragon")
 * - vida: Puntos de vida del enemigo
 * - ataque: Puntos de ataque del enemigo
 * - habilidad: Habilidad especial del enemigo
 * - descripcion: Descripcion detallada del enemigo
 * - favorito: Indica si el enemigo está marcado como favorito
 * - notas: Información adicional o notas sobre el enemigo
 *Relaciones:
 * - usuariosFavoritos: Relacion muchos a muchos con la entidad Usuario, representa los usuarios que
 *   han marcado al enemigo como favorito. Se ignora en JSON para evitar ciclos de serializacion.
 */

//Creamos todas las anotaciones de lombok
@Entity //Esta annotation representa una tabla en la base de datos
@Data //Lombok genera automáticamente getters, setters, toString, equals y hashcode
@NoArgsConstructor //Lombok genera un constructor vació(sin parameters)
@AllArgsConstructor //Lombok genera un constructor con todos los campos de la clase
public class Enemigo
{
    @Id // Clave primaria
    //Indica que el valor de ID se genera automáticamente(Auto-incremental)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    Integer idEnemigo;
    String nombre;
    String tipo;
    Integer vida;
    Integer ataque;
    String habilidad;
    String descripcion;
    Boolean favorito;
    String notas;

    /**
     * Lista de usuarios que han marcado al enemigo como favorito
     * Many-to-Many: muchos enemigos pueden ser favoritos de muchos usuarios
     * @JsonIgnore para evitar ciclos de serializacion al convertir a JSON
     */
    @ManyToMany(mappedBy = "favoritos")
    @JsonIgnore
    private List<Usuario> usuariosFavoritos = new ArrayList<>();
}
