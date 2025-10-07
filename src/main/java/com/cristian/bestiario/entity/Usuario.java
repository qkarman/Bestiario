package com.cristian.bestiario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Entidad que representa un usuario en la base de datos
 * Cada usuario puede tener una lista de enemigos favoritos(relacion Many-to-Many)
 * Campos:
 * - idUsuario: Identificador unico del usuario(Clave primaria, auto-incremental)
 * - nombreUsuario: Nombre o alias del usuario
 * - favoritos: Conjunto de enemigos marcados como favoritos por el usuario
 * Relaciones:
 * - favoritos: Many-to-Many con la entidad Enemigo mediante la tabla intermedia
 *  "usuario_favoritos". Cada usuario puede tener muchos enemigos favoritos y
 *  cada enemigo puede ser favorito de muchos usuarios
 * Métodos:
 * - toggleFavorito(Enemigo enemigo): Agrega o elimina a un enemigo de la lista de favoritos
 */
@Entity //Esta annotation representa una tabla en la base de datos
@Data //Lombok genera automáticamente getters, setters, toString, equals y hashcode
@ToString(exclude = "enemigosFavoritos")
@NoArgsConstructor //Lombok genera un constructor vació(sin parameters)
@AllArgsConstructor
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Clave primaria auto-incremental
    private Integer idUsuario;
    private String nombreUsuario;

    /**
     * Relacion Many-to-Many con Enemigo
     * Tabla intermedia: usuario_favoritos
     * - joinColumns: columna que referencia a usuario
     * - inverseJoinColumns: columna que hace referencia a Enemigo
     */
    @ManyToMany
    @JoinTable(name = "usuario_favoritos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_enemigo"))
    private Set<Enemigo> favoritos = new HashSet<>();

    /**
     * Metodo para agregar o eliminar a un enemigo de la lista de favoritos
     * si el enemigo ya está en favoritos, se elimina, si no, se agrega
     * @param enemigo Enemigo a togglear(Cambia de estado) en favoritos
     */
    public void toggleFavorito(Enemigo enemigo)
    {
        if(favoritos.contains(enemigo))
        {
            favoritos.remove(enemigo);
        }
        else
        {
            favoritos.add(enemigo);
        }
    }
}
