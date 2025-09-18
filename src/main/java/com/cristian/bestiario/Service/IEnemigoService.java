package com.cristian.bestiario.Service;

import com.cristian.bestiario.entity.Enemigo;

import java.util.List;
//Falta comentarla es la siguiente
/*
Esta interfaz es como un menu de funciones que se deben implementar, sirve para que el controlador
se comunique con la logica de negocio sin saber como está implementada exactamente, esto da flexibilidad,
organizacion y mantenimiento más sencillo.
 */

//Define que funciones debe tener cualquier clase que la implemente o la use
public interface IEnemigoService
{
    //Devuelve una lista de todos los enemigos almacenados
    List<Enemigo> listarEnemigos();

    //Busca y devuelve un enemigo específico por su ID
    Enemigo buscarEnemigoId(Integer idEnemigo);

    //Guarda un nuevo enemigo o actualiza uno existente(si ya tiene id)
    Enemigo guardarEnemigo(Enemigo enemigo);

    //Elimina un enemigo por su ID
    void eliminarEnemigoId(Integer idEnemigo);
}
