package com.cristian.bestiario.Controller;

import com.cristian.bestiario.Service.EnemigoService;
import com.cristian.bestiario.entity.Enemigo;
import com.excepciones.RecursoNoEncontradoExcepcion;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController //Indica que esta clase es un controlador REST
//Ruta base para acceder a los endpoints
@RequestMapping("bestiario-app") //http://localhost:8080/bestiario-app/enemigos
public class EnemigoController
{
    //Imprimir information en consola util para debugging
    private static final Logger log = LoggerFactory.getLogger(EnemigoController.class);

    @Autowired
    private EnemigoService enemigoService;

    //*Metodo para obtener enemigos
    @GetMapping("/enemigos") //http://localhost:8080/bestiario-app/enemigos
    public List<Enemigo> obtenerEnemigos()
    {
        List<Enemigo> enemigos = this.enemigoService.listarEnemigos();
        log.info("Enemigos obtenidos: ");
        enemigos.forEach(enemigo -> log.info(enemigo.toString()));
        return enemigos;
    }

    //*Metodo para guardar enemigos
    @PostMapping("/enemigos")
    public Enemigo agregarEnemigo(@RequestBody Enemigo enemigo)
    {
        log.info("enemigo a agregar: " + enemigo);
        return this.enemigoService.guardarEnemigo(enemigo);
    }

    //*Metodo para obtener enemigos por id
    @GetMapping("/enemigo/{id}")
    public ResponseEntity<Enemigo> obtenerEnemigoId(@PathVariable int id)
    {
        Enemigo enemigo = this.enemigoService.buscarEnemigoId(id);
        if(enemigo != null)
        {
            return ResponseEntity.ok(enemigo);
        }
        else
        {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
    }

    //*Metodo para actualizar el enemigo
    @PutMapping("/enemigos/{id}")
    public ResponseEntity<Enemigo> actualizarEnemigo(@PathVariable int id, @RequestBody Enemigo enemigoRecibido)
    {
        Enemigo enemigo = this.enemigoService.buscarEnemigoId(id);
        enemigo.setNombre(enemigoRecibido.getNombre());
        enemigo.setTipo(enemigoRecibido.getTipo());
        enemigo.setVida(enemigoRecibido.getVida());
        enemigo.setAtaque(enemigoRecibido.getAtaque());
        enemigo.setHabilidad(enemigoRecibido.getHabilidad());
        enemigo.setDescripcion(enemigoRecibido.getDescripcion());

        //Guardamos la informacion
        this.enemigoService.guardarEnemigo(enemigo);
        return ResponseEntity.ok(enemigo);
    }

    //*Creamos el metodo eliminar enemigo
    @DeleteMapping("/enemigos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEnemigo(@PathVariable int id)
    {
        Enemigo enemigo = this.enemigoService.buscarEnemigoId(id);

        if(enemigo == null)
        {
            throw new RecursoNoEncontradoExcepcion(" No se encontro el id: " + id);
        }
        this.enemigoService.eliminarEnemigoId(enemigo.getIdEnemigo());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    //! ¡Creamos un metodo como nuevo endpoint para el filtro PRUEBA
    @GetMapping("/enemigos/tipo/{tipo}")
    public List<Enemigo> obtenerEnemigosPorTipo(@PathVariable String tipo)
    {
        List<Enemigo> enemigos = this.enemigoService.buscarEnemigosPorTipo(tipo);
        log.info("Enemigos del tipo " + tipo + ":");
        enemigos.forEach(enemigo -> log.info(enemigo.toString()));
        return enemigos;
    }

    //! Creamos un metodo como nuevo endpoint para el filtro de nombre, vida y ataque
    @GetMapping("/enemigos/vida/{vida}")//http://localhost:8080/bestiario-app/enemigos/vida/10
    public List<Enemigo> obtenerEnemigoPorNombreVidaAtaque(@PathVariable Integer vida)
    {
        List<Enemigo> enemigos = this.enemigoService.buscarEnemigosPorVida(vida);
        log.info("Vida de enemigos: " + vida );
        enemigos.forEach(enemigo -> log.info(enemigo.toString()));
        return enemigos;
    }
}
