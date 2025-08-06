package com.cristian.bestiario.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
