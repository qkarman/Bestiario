package com.cristian.bestiario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity //Esta annotation representa una tabla en la base de datos
@Data //Lombok genera automáticamente getters, setters, toString, equals y hashcode
@NoArgsConstructor //Lombok genera un constructor vació(sin parameters)
@AllArgsConstructor
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombreUsuario;

    @ManyToMany
    @JoinTable(name = "usuario_favoritos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_enemigo"))
    private Set<Enemigo> favoritos = new HashSet<>();

    //Toggle Favorito
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
