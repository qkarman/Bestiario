package com.cristian.bestiario.repository;

import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.entity.Nota;
import com.cristian.bestiario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/*
Esta clase permite buscar la nota de un usuario para un enemigo específico
 */
public interface NotaRepository extends JpaRepository<Nota, Integer>
{
    Optional<Nota> findByUsuarioAndEnemigo(Usuario usuario, Enemigo enemigo);
}
