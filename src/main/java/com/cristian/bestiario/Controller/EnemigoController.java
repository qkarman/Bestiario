package com.cristian.bestiario.Controller;

import com.cristian.bestiario.Service.EnemigoService;
import com.cristian.bestiario.dto.DescripcionDTO;
import com.cristian.bestiario.dto.StatsDTO;
import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.excepciones.RecursoNoEncontradoExcepcion;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para gestionar operaciones relacionadas con los enemigos del bestiario
 * proporciona endpoints para realizar operaciones CRUD y filtros personalizados
 *
 * Ruta base: http://localhost:8080/bestiario-app
 *
 * Ejemplo de uso:
 * - Listar enemigos: GET /bestiario-app/enemigos
 * - Obtener enemigo por ID: GET /bestiario-app/enemigos/{id}
 * - Crear enemigo: POST /bestiario-app/enemigos
 * - Actualizar enemigo: PUT /bestiario-app/enemigos/{id}
 * - Eliminar enemigo: DELETE /bestiario-app/enemigos/{id}
 * - Filtros avanzados (por tipo, vida, stats, etc).
 */
@RestController //Indica que esta clase es un controlador REST
//Ruta base para acceder a los endpoints
@RequestMapping("bestiario-app") //http://localhost:8080/bestiario-app/enemigos
public class EnemigoController
{
    //Imprimir information en consola util para debugging
    private static final Logger log = LoggerFactory.getLogger(EnemigoController.class);

    @Autowired
    private EnemigoService enemigoService;

    /**
     * Obtiene todos los enemigos registrados en la base de datos
     *
     * @return Lista de objetos {@link Enemigo}
     */
    @GetMapping("/enemigos") //http://localhost:8080/bestiario-app/enemigos
    public List<Enemigo> obtenerEnemigos()
    {
        List<Enemigo> enemigos = this.enemigoService.listarEnemigos();
        log.info("Enemigos obtenidos: ");
        enemigos.forEach(enemigo -> log.info(enemigo.toString()));
        return enemigos;
    }

    /**
     * Crea un nuevo enemigo en el sistema
     *
     * @param enemigo objeto {link Enemigo} recibiendo en el cuerpo de la peticion
     * @return el enemigo guardado
     */
    @PostMapping("/enemigos")
    public Enemigo agregarEnemigo(@RequestBody Enemigo enemigo)
    {
        log.info("enemigo a agregar: " + enemigo);
        return this.enemigoService.guardarEnemigo(enemigo);
    }

    /**
     * Busca un enemigo por su ID
     *
     * @param id identificador unico del enemigo
     * @return {@link ResponseEntity} con el enemigo si existe
     * @throws RecursoNoEncontradoExcepcion si no se encuentra el enemigo
     */
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
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
        }
    }

    /**
     * Actualiza los datos de un enemigo existente
     *
     * @param id identificador del enemigo a actualizar
     * @param enemigoRecibido datos actualizados enviados en el cuerpo de la peticion
     * @return {@link ResponseEntity} con el enemigo actualizado
     */
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

        //Guardamos la información
        this.enemigoService.guardarEnemigo(enemigo);
        return ResponseEntity.ok(enemigo);
    }

    /**
     * Elimina un enemigo de la base de datos
     *
     * @param id identificador del enemigo a eliminar
     * @return {@link ResponseEntity} con confirmacion de eliminacion
     * @throws RecursoNoEncontradoExcepcion si el enemigo no existe
     */
    @DeleteMapping("/enemigos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEnemigo(@PathVariable int id)
    {
        Enemigo enemigo = this.enemigoService.buscarEnemigoId(id);

        if(enemigo == null)
        {
            throw new RecursoNoEncontradoExcepcion(" No se encontró el id: " + id);
        }
        this.enemigoService.eliminarEnemigoId(enemigo.getIdEnemigo());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    /**
     * Filtra enemigos por su tipo (ej. "orco", "dragon")
     *
     * @param tipo tipo de enemigo
     * @return lista de enemigos que coinciden con el tipo
     */
    //! ¡Creamos un método como nuevo endpoint para el filtro PRUEBA!
    @GetMapping("/enemigos/tipo/{tipo}")
    public List<Enemigo> obtenerEnemigosPorTipo(@PathVariable String tipo)
    {
        List<Enemigo> enemigos = this.enemigoService.buscarEnemigosPorTipo(tipo);
        log.info("Enemigos del tipo " + tipo + ":");
        enemigos.forEach(enemigo -> log.info(enemigo.toString()));
        return enemigos;
    }

    /**
     * Filtra enemigos por su nivel de vida
     *
     * @param vida puntos de vida a filtrar
     * @return lista de enemigos con la vida indicada
     */
    //! Creamos un método como nuevo endpoint para el filtro de nombre, vida y ataque
    @GetMapping("/enemigos/vida/{vida}")//http://localhost:8080/bestiario-app/enemigos/vida/10
    public List<Enemigo> obtenerEnemigoPorNombreVidaAtaque(@PathVariable Integer vida)
    {
        List<Enemigo> enemigos = this.enemigoService.buscarEnemigosPorVida(vida);
        log.info("Vida de enemigos: " + vida );
        enemigos.forEach(enemigo -> log.info(enemigo.toString()));
        return enemigos;
    }

    /**
     * Obtiene estadísticas de enemigos filtrados por nombre
     *
     * @param nombre nombre del enemigo
     * @return lista de {@link StatsDTO} con estadísticas
     */
    //! Hacemos pruebas de crear el endpoint para el DTO Stats
    @GetMapping("/enemigos/stats/{nombre}")//http://localhost:8080/bestiario-app/enemigos/stats/Orco
    public List<StatsDTO> obtenerStatsPorNombre(@PathVariable String nombre)
    {
        return enemigoService.buscarStatsPorNombre(nombre);
    }

    /**
     * Obtiene la descripcion de un enemigo por nombre
     *
     * @param nombre nombre del enemigo
     * @return lista de {@link DescripcionDTO} con descripciones
     */
    //!Creamos el endpoint para el DTO stats
    @GetMapping("/enemigos/descripcion/{nombre}")//http://localhost:8080/bestiario-app/enemigos/descripcion/nombre
    public List<DescripcionDTO> obtenerDescripcionPorNombre(@PathVariable String nombre)
    {
        return enemigoService.buscarDescripcionPorNombre(nombre);
    }

    /**
     * Filtra enemigos considerados "poderosos" según valores minimos de ataque y vida
     *
     * @param ataqueMin ataque minimo requerido
     * @param vidaMin vida minima requerida
     * @return lista de {@link StatsDTO} que cumplen con los parametros
     */
    //! Creamos el endpoint para los stats de enemigo poderoso
    @GetMapping("/poderoso")//http://localhost:8080/bestiario-app/poderoso?ataqueMin=20&vidaMin=50
    public List<StatsDTO> filtrarEnemigosPoderosos(@RequestParam int ataqueMin, @RequestParam int vidaMin)
    {
        return enemigoService.obtenerStatsPoderosos(ataqueMin, vidaMin);
    }
}
