package com.cristian.bestiario.Controller;

import com.cristian.bestiario.Service.NotaService;
import com.cristian.bestiario.dto.NotasDTO;
import com.cristian.bestiario.entity.Nota;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios/{idUsuario}/enemigos/{idEnemigo}/nota")
public class NotaController
{
    private final NotaService notaService;

    @PostMapping
    public Nota crearOModificarNota(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo, @RequestBody String contenido)
    {
        return notaService.crearOModificarNota(idUsuario, idEnemigo, contenido);
    }

    @GetMapping
    public Nota verNota(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo)
    {
        return notaService.verNota(idUsuario, idEnemigo);
    }

    @DeleteMapping
    public void eliminarNota(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo)
    {
        notaService.eliminarNota(idUsuario, idEnemigo);
    }

    @GetMapping("/{idUsuario}/nota/{idEnemigo}")
    public NotasDTO verNota(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo) {
        return notaService.verNota(idUsuario, idEnemigo);
    }
}
