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

@Service
@AllArgsConstructor
public class NotaService
{
    private final NotaRepository notaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EnemigoRepository enemigoRepository;

    public NotasDTO crearOModificarNota(Integer idUsuario, Integer idEnemigo, String contenido)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Enemigo enemigo = enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"));

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

    public void eliminarNota(Integer idUsuario, Integer idEnemigo)
    {
        Nota nota = notaRepository.findByUsuarioAndEnemigo(usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado")),
                        enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"))
                ).orElseThrow(() -> new NotaNotFoundExcepcion("Nota no encontrada"));

        notaRepository.delete(nota);
    }

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
