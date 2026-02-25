package com.cristian.bestiario.Controller;

import com.cristian.bestiario.Service.UsuarioService;
import com.cristian.bestiario.dto.FavoritosDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor //Lombok: Genera un constructor con todos los argumento automáticamente
@RestController //Indica que esta clase es un controlador REST
@RequestMapping("/usuarios") //Ruta base para acceder a endpoints relacionados con usuarios
public class UsuarioController
{
    //Servicio encargado de la logica de negocio de usuarios y sus favoritos
    private final UsuarioService usuarioService;

    //* Endpoint para cambiar el estado "favorito" de un enemigo
    // Se usa POST porque modifica el estado de la base de datos (toggle)
    // @PathVariable: Captura él, id del usuario de la URL
    @PostMapping("/{idUsuario}/favorito/{idEnemigo}")
    public void toggleFavorito(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo)
    {
        usuarioService.toggleFavorito(idUsuario, idEnemigo); // Delegamos al servicio
    }

    //*Endpoint para obtener la lista de favoritos de un usuario
    @GetMapping("/{idUsuario}/favoritos")
    public List<FavoritosDTO> obtenerFavoritos(@PathVariable Integer idUsuario)
    {
        return usuarioService.obtenerFavoritos(idUsuario); //Retorna la lista de favoritos como DTO
    }

    //!Nuevo codigo para frontend
    @GetMapping("/{idUsuario}/enemigos")
    public List<FavoritosDTO> listarEnemigosConFavoritos(@PathVariable Integer idUsuario)
    {
        return usuarioService.listarEnemigosConFavoritos(idUsuario);
    }

    //!Agregamos código para actualizar
    @PutMapping("/{idUsuario}/enemigos/{idEnemigo}/favorito")
    public FavoritosDTO actualizarFavorito(
            @PathVariable Integer idUsuario,
            @PathVariable Integer idEnemigo,
            @RequestBody FavoritosDTO favoritoDTO) {
        return usuarioService.actualizarFavorito(
                idUsuario,
                idEnemigo,
                favoritoDTO.isFavorito());
    }
}
