package com.cristian.bestiario.Controller;

import com.cristian.bestiario.Service.NotaService;
import com.cristian.bestiario.dto.NotaRequestDTO;
import com.cristian.bestiario.dto.NotasDTO;
import com.cristian.bestiario.entity.Nota;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor // Lombok: Genera un constructor con todos los argumentos automáticamente
@RestController //Indica que esta clase es un controlador REST
// Ruta base que depende de usuarios y enemigo (jerárquica, estilo RESTful)
@RequestMapping("/usuarios/{idUsuario}/enemigos/{idEnemigo}/nota")
public class NotaController
{
    //Servicio encargado de la logica de negocio de las notas
    private final NotaService notaService;

    //* Endpoint para crear o modificar una nota
    // Se usa POST porque el mismo método sirve tanto para crear como actualizar
    // @PathVariable: Captura el id del usuario de la URL
    // @RequestBody: Recibe el contenido de la nota en el cuerpo
    @PostMapping
    public NotasDTO crearOModificarNota(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo, @RequestBody NotaRequestDTO request)
    {
        //Delegamos al servicio para que cree o actualice la nota
        return notaService.crearOModificarNota(idUsuario, idEnemigo, request.getContenido());
    }

    //* Endpoint para ver una nota asociada a un usuario y un enemigo
    @GetMapping
    public NotasDTO verNota(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo)
    {
        return notaService.verNotas(idUsuario, idEnemigo);
    }

    //* Endpoint para eliminar una nota
    @DeleteMapping
    public void eliminarNota(@PathVariable Integer idUsuario, @PathVariable Integer idEnemigo)
    {
        notaService.eliminarNota(idUsuario, idEnemigo);
    }
}
