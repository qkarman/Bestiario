package com.cristian.bestiario.repository;

import com.cristian.bestiario.entity.Enemigo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
Es una interfaz que hereda de JpaRepository<Enemigo,Integer>, lo que significa
Enemigo: es la entidad que va a manejar
Integer: es el tipo de dato de su identificador(el ID del enemigo)
 */
public interface EnemigoRepository extends JpaRepository<Enemigo,Integer>
{
    //! Devuelve una lista de enemigos filtrados por tipo PRUEBA
    List<Enemigo> findByTipo(String tipo);

    //! Devuelve una lista de enemigos filtrados por nombre
    List<Enemigo> findByVida(Integer vida);

    //Hacer consultas del CRUD
    /*
    metodos posibles para hacer aqui como consultas
    findAll();
    findById(id);
    save(entidad);
    deleteById(id);
    existsById(id);
    */
}
