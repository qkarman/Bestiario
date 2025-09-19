package com.cristian.bestiario.Service;

import com.cristian.bestiario.dto.NotasDTO;
import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.entity.Nota;
import com.cristian.bestiario.entity.Usuario;
import com.cristian.bestiario.repository.EnemigoRepository;
import com.cristian.bestiario.repository.NotaRepository;
import com.cristian.bestiario.repository.UsuarioRepository;
import com.cristian.bestiario.excepciones.NotaNotFoundExcepcion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de gestionar la logica de negocio para las notas
 * una nota representa un comentario o apunte que un usuario guarda sobre un enemigo
 * Este servicio actua como intermediario entre los controladores (capa web)
 * y los repositorios (capa de acceso a datos)
 */
@Service
@AllArgsConstructor //Genera un constructor con todos los atributos
public class NotaService
{
    private final NotaRepository notaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EnemigoRepository enemigoRepository;

    /**
     * Crea una nueva nota o modifica una existente para un usuario y enemigo específico
     * Flujo:
     * - Verifica si el usuario y enemigo existen (si no, lanza una excepcion)
     * - busca si ya existe -> la actualiza, si no -> crea una nueva
     * - Guarda la nota en la base de datos y devuelve un DTO con la información
     * @param idUsuario ID del usuario que escribe la nota
     * @param idEnemigo ID del enemigo al que pertenece la nota
     * @param contenido Objeto NotasDTO con los datos de la nota creada o modificada
     * @return Objeto NotasDTO con los datos de la nota creada y modificada
     */
    public NotasDTO crearOModificarNota(Integer idUsuario, Integer idEnemigo, String contenido)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Enemigo enemigo = enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"));

        //Busca la nota existente, o crea una nueva si no existe
        Nota nota = notaRepository.findByUsuarioAndEnemigo(usuario, enemigo).orElse(new Nota(null, usuario, enemigo, ""));

        nota.setContenido(contenido);
        Nota notaGuardada = notaRepository.save(nota);

        return new NotasDTO(
                notaGuardada.getIdNotas(),
                notaGuardada.getUsuario().getNombreUsuario(),
                notaGuardada.getEnemigo().getNombre(),
                notaGuardada.getContenido()
        );
    }

    /**
     * Devuelve la nota de un usuario para un enemigo
     * @param idUsuario ID del usuario
     * @param idEnemigo ID del enemigo
     * @return NotasDTO con la información de la nota encontrada
     * @throws NotaNotFoundExcepcion si no existe la nota
     */
    public NotasDTO verNota(Integer idUsuario, Integer idEnemigo)
    {
        Nota nota = notaRepository.findByUsuarioAndEnemigo(usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("usuario no encontrado")),
                enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"))
        ).orElseThrow(() -> new NotaNotFoundExcepcion("Nota no encontrada"));

        return new NotasDTO(
                nota.getIdNotas(),
                nota.getUsuario().getNombreUsuario(),
                nota.getEnemigo().getNombre(),
                nota.getContenido()
        );
    }

    /**
     * Elimina la nota de un usuario para un enemigo específico
     * @param idUsuario ID del usuario
     * @param idEnemigo ID del enemigo
     * @throws NotaNotFoundExcepcion si no existe la nota
     */
    public void eliminarNota(Integer idUsuario, Integer idEnemigo)
    {
        Nota nota = notaRepository.findByUsuarioAndEnemigo(usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado")),
                        enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"))
                ).orElseThrow(() -> new NotaNotFoundExcepcion("Nota no encontrada"));

        notaRepository.delete(nota);
    }

    /**
     * Variante para obtener una nota usando directamente IDs de usuario y enemigo
     * utiliza un @Query definido en NotaRepository
     * @param idUsuario ID del usuario
     * @param idEnemigo ID del enemigo
     * @return NotasDTO con la información de la nota encontrada
     * @throws NotaNotFoundExcepcion si no existe la nota
     */
    public NotasDTO verNotas(Integer idUsuario, Integer idEnemigo)
    {
        Nota nota = notaRepository.findNota(idUsuario, idEnemigo).orElseThrow(() -> new NotaNotFoundExcepcion("Nota no encontrada"));

        return new NotasDTO(
                nota.getIdNotas(),
                nota.getUsuario().getNombreUsuario(),
                nota.getEnemigo().getNombre(),
                nota.getContenido()
        );
    }
}
