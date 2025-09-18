package com.cristian.bestiario.repository;

import com.cristian.bestiario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad Usuario
 * Extiende JpaRepository, lo que proporciona métodos CRUD y de paginacion automáticamente
 * Tipos genericos:
 * - Usuario: Entidad que maneja el repositorio
 * - Integer: tipo de la clave primaria (idUsuario)
 * Funcionalidad:
 * - Permite guardar, actualizar, eliminar y consultar usuarios de la base de datos
 * - Gracias a JpaRepository, ya cuenta con métodos como:
 *  findAll(), findById(id), save(entidad), deleteById(id), existsById(id), etc.
 *  Nota:
 *  - Actualmente no tiene métodos personalizados, pero se pueden agregar consultas JPQL
 *   o usando Query Methods según se necesite.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{

}
