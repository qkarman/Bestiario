package com.cristian.bestiario.Controller;

import com.cristian.bestiario.Service.UsuarioService;
import com.cristian.bestiario.dto.FavoritosDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{
    private final UsuarioService usuarioService;

    //Endpoint para el metodo toggle favorito
    @PostMapping("/{idUsuario}/favorito/{idEnemigo}")
    public void toggleFavorito(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo)
    {
        usuarioService.toggleFavorito(idUsuario, idEnemigo);
    }

    //Endpoint para obtener favoritos
    @GetMapping("/{idUsuario}/favoritos")
    public List<FavoritosDTO> obtenerFavoritos(@PathVariable Integer idUsuario)
    {
        return usuarioService.obtenerFavoritos(idUsuario);
    }
}
