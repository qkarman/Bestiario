package com.cristian.bestiario.Service;

import com.cristian.bestiario.dto.NotasDTO;
import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.entity.Nota;
import com.cristian.bestiario.entity.Usuario;
import com.cristian.bestiario.repository.EnemigoRepository;
import com.cristian.bestiario.repository.NotaRepository;
import com.cristian.bestiario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotaService
{
    private final NotaRepository notaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EnemigoRepository enemigoRepository;

    public Nota crearOModificarNota(Integer idUsuario, Integer idEnemigo, String contenido)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Enemigo enemigo = enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"));

        Nota nota = notaRepository.findByUsuarioAndEnemigo(usuario, enemigo).orElse(new Nota(null, usuario, enemigo, ""));

        nota.setContenido(contenido);
        return notaRepository.save(nota);
    }

    public Nota verNota(Integer idUsuario, Integer idEnemigo)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Enemigo enemigo = enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"));

        return notaRepository.findByUsuarioAndEnemigo(usuario, enemigo).orElseThrow(() -> new RuntimeException("Nota no encontrada"));
    }

    public void eliminarNota(Integer idUsuario, Integer idEnemigo)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Enemigo enemigo = enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"));

        Nota nota = notaRepository.findByUsuarioAndEnemigo(usuario, enemigo).orElseThrow(() -> new RuntimeException("Nota no encontrada"));

        notaRepository.delete(nota);
    }

    public NotasDTO verNotas(Integer idUsuario, Integer idEnemigo)
    {
        Nota nota = notaRepository.findByUsuario_IdUsuarioAndEnemigo_IdEnemigo(idUsuario, idEnemigo).orElseThrow(() -> new RuntimeException("Nota no encontrada"));

        return new NotasDTO(
                nota.getIdNotas(),
                nota.getUsuario().getNombreUsuario(),
                nota.getEnemigo().getNombre(),
                nota.getContenido()
        );
    }
}
