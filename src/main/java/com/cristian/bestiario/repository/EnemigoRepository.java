package com.cristian.bestiario.repository;

import com.cristian.bestiario.dto.DescripcionDTO;
import com.cristian.bestiario.dto.StatsDTO;
import com.cristian.bestiario.entity.Enemigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //! Devuelve los stats del personaje usando un DTO como enviador de datos
    @Query("SELECT new com.cristian.bestiario.dto.StatsDTO(e.nombre, e.vida, e.ataque) FROM Enemigo e WHERE e.nombre = :nombre")
    List<StatsDTO> findStatsByNombre(@Param("nombre") String nombre);

    //! Devuelve la description del personaje con la clase DTO
    @Query("SELECT new com.cristian.bestiario.dto.DescripcionDTO(e.nombre, e.tipo, e.descripcion)" +
            " FROM Enemigo e WHERE LOWER(e.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")

    List<DescripcionDTO> findDescripcionByNombre(@Param("nombre") String nombre);

    //! Devuelve enemigos con el ataque o vida mayor al asignado por el usuario
    @Query("SELECT new com.cristian.bestiario.dto.StatsDTO(e.nombre, e.vida, e.ataque) " +
    "FROM Enemigo e " +
    "WHERE e.ataque >= :ataqueMin " +
    "AND e.vida >= :vidaMin")

    List<StatsDTO> filtrarEnemigosPoderosos(@Param("ataqueMin") int ataqueMin, @Param("vidaMin") int vidaMin);

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
