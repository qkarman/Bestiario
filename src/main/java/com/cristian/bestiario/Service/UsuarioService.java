package com.cristian.bestiario.Service;

import com.cristian.bestiario.dto.FavoritosDTO;
import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.entity.Usuario;
import com.cristian.bestiario.repository.EnemigoRepository;
import com.cristian.bestiario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio encargado de gestionar la logica de negocio relacionada con los usuarios
 * Principalmente maneja la funcionalidad de:
 * - Agregar o quitar enemigos de la lista de favoritos de un usuario(toggle)
 * -Obtener la lista de favoritos en forma de DTO para devolverla al cliente
 */
@AllArgsConstructor //Genera constructor con todos los repositorios inyectados
@Service
public class UsuarioService
{
    private EnemigoRepository enemigoRepository;
    private UsuarioRepository usuarioRepository;

    /**
     * Metodo que alterna (toggle) el estado de favoritos de un enemigo para un usuario
     * Flujo:
     * - Busca al usuario por ID, si no existe lanza una excepcion
     * - Busca al enemigo por ID, si no existe lanza una excepcion
     * - Usa el metodo toggleFavorito de la entidad Usuario:
     *  - Si el enemigo ya era favorito -> lo elimina
     *  - Si no lo era -> lo agrega
     * - Finalmente guarda los cambios en la base de datos
     * @param idUsuario ID del usuario que marca/desmarca el favorito
     * @param idEnemigo ID del enemigo que sera marcado/desmarcado
     */
    public void toggleFavorito(Integer idUsuario, Integer idEnemigo)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Enemigo enemigo = enemigoRepository.findById(idEnemigo).orElseThrow(() -> new RuntimeException("Enemigo no encontrado"));

        //Cambia el estado del enemigo en favoritos
        usuario.toggleFavorito(enemigo);

        //Persistimos los cambios en la BD
        usuarioRepository.save(usuario);
    }

    /**
     * Devuelve la lista de favoritos de un usuario en forma de DTO
     *
     * Flujo:
     * - Busca al usuario por ID (si no existe lanza una excepcion)
     * - Obtiene la lista de enemigos favoritos asociados al usuario
     * - Convierte cada enemigo en un objeto FavoritosDTO
     * Incluye datos basicos: nombre, ataque, vida y el flag favorito
     * @param idUsuario ID del usuario que consulta sus favoritos
     * @return Lista de FavoritosDTO con los enemigos favoritos del usuario
     */
    public List<FavoritosDTO> obtenerFavoritos(Integer idUsuario)
    {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        //Convertimos el Set favoritos en una lista
        List<Enemigo> enemigosFavoritos = new ArrayList<>(usuario.getFavoritos());

        List<FavoritosDTO> listaDTO = new ArrayList<>();

        //Transformamos cada enemigo en un FavoritosDTO con programación funcional(stream)
        return enemigosFavoritos.stream().map(e -> {
            FavoritosDTO dto = new FavoritosDTO();
            dto.setNombre(e.getNombre());
            dto.setAtaque(e.getAtaque());
            dto.setVida(e.getVida());
            dto.setFavorito(true); // Al estar en esta lista, siempre es favorito
            return dto;
        }).collect(Collectors.toList());
    }
}
