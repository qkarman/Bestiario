package com.cristian.bestiario.Service;

import com.cristian.bestiario.entity.Enemigo;

import java.util.List;

/**
 * Interfaz que define el contrato de operaciones disponibles
 * para la gestion de la entidad Enemigo en la capa de servicio
 * Propositos principales:
 * - Define las funciones basicas de negocio (CRUD) sin importar la implementacion
 * - Permite que el controlador se comunique con la logica de negocio de manera desacoplada
 * - Garantiza flexibilidad, organizacion y facilita el mantenimiento y pruebas
 * Nota:
 * Cualquier clase que implemente esta interfaz (como EnemigoService)
 * debe proveer la implementacion concreta de estos métodos
 */
public interface IEnemigoService
{
    /**
     * Devuelve una lista de todos los enemigos almacenados en la base de datos
     * @return Lista de enemigos
     */
    List<Enemigo> listarEnemigos();

    /**
     * Busca y devuelve un enemigo específico por su ID
     * @param idEnemigo ID del enemigo a buscar
     * @return Enemigo encontrado o null si no existe
     */
    Enemigo buscarEnemigoId(Integer idEnemigo);

    /**
     * Guarda un nuevo enemigo o actualiza uno existente(si ya tiene id)
     * @param enemigo Objeto enemigo a guardar o actualizar
     * @return Enemigo guardado/actualizado
     */
    Enemigo guardarEnemigo(Enemigo enemigo);

    /**
     * Elimina un enemigo según su ID
     * @param idEnemigo ID del enemigo a eliminar
     */
    void eliminarEnemigoId(Integer idEnemigo);
}
