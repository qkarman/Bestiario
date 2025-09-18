package com.cristian.bestiario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa una nota en la base de datos
 * cada nota está asociada a un usuario y a un enemigo
 * Se asegura que un usuario no pueda tener más de una nota por enemigo mediante
 * la restriccion de unicidad(unique constraint)
 * Campos:
 * - idNotas: Identificador unico de la nota (clave primaria, auto-incremental)
 * - usuario: Usuario que creo la nota(relacion Many-to-One)
 * - enemigo: Enemigo al que esta asociada la nota(relacion Many-to-One)
 * - contenido: Texto de la nota, limitado a 1000 caracteres
 * Restricciones:
 * - UniqueConstraint en (id_usuario, id_enemigo) para evitar notas duplicadas del mismo usuario
 * sobre un mismo enemigo
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id_usuario", "id_enemigo"})})
@Data // Lombok genera getters, setters, toString, equals y hashCode
@AllArgsConstructor // Constructor con todos los campos
@NoArgsConstructor // Constructor vacío para JPA y serialización
public class Nota
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Clave primaria auto-incremental
    private Integer idNotas;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // FK(Clave foránea) hacia Usuario
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_enemigo") // FK(Clave foránea) hacia Enemigo
    private Enemigo enemigo;

    @Column(length = 1000) // para que el texto pueda ser largo
    private String contenido;
}
