package com.cristian.bestiario.repository;

import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.entity.Nota;
import com.cristian.bestiario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Repositorio para la entidad Nota
 * Extiende JpaRepository, lo que proporciona métodos CRUD y de paginacion automáticamente
 * Funcionalidad principal:
 * - Permite buscar notas específicas de un usurario para un enemigo
 * - Admite consultas usando la entidad completa o directamente los IDs
 */
public interface NotaRepository extends JpaRepository<Nota, Integer>
{
    /**
     * Busca nota por usuario y enemigo usando las entidades completas
     * @param usuario Usuario propietario de la nota
     * @param enemigo Enemigo al que pertenece la nota
     * @return Optional<Nota> que contiene la nota si existe
     */
    Optional<Nota> findByUsuarioAndEnemigo(Usuario usuario, Enemigo enemigo);

    /**
     * Busca una nota por los IDs de usuarios y enemigo usando una consulta JPQL explicita
     * @param idUsuario ID del usuario
     * @param idEnemigo ID del enemigo
     * @return Optional<Nota> que contiene la nota si existe
     */
    @Query("SELECT n FROM Nota n WHERE n.usuario.idUsuario = :idUsuario AND n.enemigo.idEnemigo = :idEnemigo")
    Optional<Nota> findNota(@Param("idUsuario") Integer idUsuario, @Param("idEnemigo") Integer idEnemigo);
}
