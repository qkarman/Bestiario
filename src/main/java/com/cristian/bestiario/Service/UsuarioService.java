package com.cristian.bestiario.Service;

import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.entity.Usuario;
import com.cristian.bestiario.repository.EnemigoRepository;
import com.cristian.bestiario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class UsuarioService
{
    private EnemigoRepository enemigoRepository;
    private UsuarioRepository usuarioRepository;

    //! Creamos el metodo de favoritos
    //public UsuarioService(UsuarioRepository usuarioRepository, EnemigoRepository enemigoRepository)
   // {

  //  }

    //Toggle favorito
    public void toggleFavorito(Integer idUsuario, Integer idEnemigo)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Enemigo enemigo = enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"));

        usuario.toggleFavorito(enemigo);
        usuarioRepository.save(usuario); //Persistimos los cambios
    }

    //Obtener lista de favoritos de un usuario
    public Set<Enemigo> obtenerFavoritos(Integer idUsuario)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuario.getFavoritos();
    }
}
