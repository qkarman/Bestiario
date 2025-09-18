package com.cristian.bestiario.repository;

import com.cristian.bestiario.dto.DescripcionDTO;
import com.cristian.bestiario.dto.StatsDTO;
import com.cristian.bestiario.entity.Enemigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repositorio para la entidad Enemigo
 * Extiende JpaRepository, lo que proporciona métodos CRUD y de paginacion de forma automatica
 * Tipos genericos:
 * - Enemigo: entidad que maneja el repositorio
 * - Integer: tipo de dato de la clave primaria (idEnemigo)
 * Funcionalidad:
 * - Permite consultas personalizadas usando JPQL
 * - Devuelve resultados usando DTOs para exponer toda la entidad
 */
public interface EnemigoRepository extends JpaRepository<Enemigo,Integer>
{
    /**
     * Busca enemigos por su tipo (ej. "Orco", "Dragon")
     *
     * @param tipo Tipo del enemigo
     * @return Lista de enemigos que coinciden con el tipo
     */
    //! Devuelve una lista de enemigos filtrados por tipo PRUEBA
    List<Enemigo> findByTipo(String tipo);

    /**
     * Busca enemigos por su valor de vida
     *
     * @param vida Puntos de vida del enemigo
     * @return Lista de enemigos que tienen la vida indicada
     */
    //! Devuelve una lista de enemigos filtrados por nombre
    List<Enemigo> findByVida(Integer vida);

    /**
     * Obtiene estadísticas de un enemigo específico usando StatsDTO
     *
     * @param nombre Nombre del enemigo
     * @return Lista de StatsDTO con nombre, vida y ataque
     */
    //! Devuelve los stats del personaje usando un DTO como enviador de datos
    @Query("SELECT new com.cristian.bestiario.dto.StatsDTO(e.nombre, e.vida, e.ataque) FROM Enemigo e WHERE e.nombre = :nombre")
    List<StatsDTO> findStatsByNombre(@Param("nombre") String nombre);

    /**
     * Obtiene la descripcion de un enemigo usando DescripcionDTO
     * La búsqueda es insensible a mayúsculas y busca coincidencias parciales
     * @param nombre Nombre del enemigo
     * @return Lista de DescripcionDTO con nombre, tipo y descripcion
     */
    //! Devuelve la description del personaje con la clase DTO
    @Query("SELECT new com.cristian.bestiario.dto.DescripcionDTO(e.nombre, e.tipo, e.descripcion)" +
            " FROM Enemigo e WHERE LOWER(e.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")

    List<DescripcionDTO> findDescripcionByNombre(@Param("nombre") String nombre);

    /**
     * Filtra enemigos considerados "Poderosos" según los valores minimos de ataque y vida
     * @param ataqueMin Ataque minimo requerido
     * @param vidaMin Vida minima requerida
     * @return Lista de StatsDTO que cumplen con los parametros
     */
    //! Devuelve enemigos con el ataque o vida mayor al asignado por el usuario
    @Query("SELECT new com.cristian.bestiario.dto.StatsDTO(e.nombre, e.vida, e.ataque) " +
    "FROM Enemigo e " +
    "WHERE e.ataque >= :ataqueMin " +
    "AND e.vida >= :vidaMin")

    List<StatsDTO> filtrarEnemigosPoderosos(@Param("ataqueMin") int ataqueMin, @Param("vidaMin") int vidaMin);

    // Métodos CRUD disponibles automáticamente gracias a JpaRepository:
    // findAll(), findById(id), save(entidad), deleteById(id), existsById(id)
}
