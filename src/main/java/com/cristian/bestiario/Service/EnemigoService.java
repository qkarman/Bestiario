package com.cristian.bestiario.Service;

import com.cristian.bestiario.dto.DescripcionDTO;
import com.cristian.bestiario.dto.StatsDTO;
import com.cristian.bestiario.entity.Enemigo;
import com.cristian.bestiario.repository.EnemigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar la logica de negocio relacionada con la entidad enemigo
 * Funciones principales:
 * - Ejecuta operaciones CRUD sobre enemigos
 * - Implementa filtros personalizados(por tipo, vida, stats, etc.)
 * - Comunica el controlador con el repositorio para acceder a la base de datos
 * Nota:
 * - Al implementar IEnemigoService, garantiza que ofrece los métodos basicos: listar, buscar, guardar
 *  y eliminar enemigos.
 * - Los métodos de filtro permiten consultas más avanzadas y devuelven DTOs cuando es necesario
 */
@Service
public class EnemigoService implements IEnemigoService
{
    /**
     * Repositorio para acceder a los datos de la entidad Enemigo en la base de datos
     * La inyección de dependencias es automatica gracias a @Autowired
     */
    @Autowired
    private EnemigoRepository enemigoRepository;

    /**
     * Recupera todos los enemigos almacenados en la base de datos
     * @return Lista de todos los enemigos
     */
    @Override
    public List<Enemigo> listarEnemigos()
    {
        return this.enemigoRepository.findAll();
    }

    /**
     * Busca un enemigo por su ID
     * @param idEnemigo ID del enemigo a buscar
     * @return Enemigo si existe, o null si no se encuentra
     */
    @Override
    public Enemigo buscarEnemigoId(Integer idEnemigo)
    {
        Enemigo enemigo = this.enemigoRepository.findById(idEnemigo).orElse(null);
        return enemigo;
    }

    /**
     * Guarda un nuevo enemigo o actualiza uno existente si ya tiene ID
     * @param enemigo Objeto enemigo a guardar o actualizar
     * @return Enemigo guardado o actualizado
     */
    @Override
    public Enemigo guardarEnemigo(Enemigo enemigo)
    {
        return this.enemigoRepository.save(enemigo);
    }

    /**
     * Elimina un enemigo de la base de datos por su ID
     * @param idEnemigo ID del enemigo a eliminar
     */
    //*Elimina el enemigo con el ID especificado
    @Override
    public void eliminarEnemigoId(Integer idEnemigo)
    {
        this.enemigoRepository.deleteById(idEnemigo);
    }

    // =========================
    // Métodos de filtros avanzados
    // =========================

    /**
     * Busca enemigos por su tipo (ej. "Orco", "Dragon")
     * @param tipo Tipo de enemigo
     * @return Lista de enemigos que coinciden con el tipo
     */
    public List<Enemigo> buscarEnemigosPorTipo(String tipo)
    {
        return enemigoRepository.findByTipo(tipo);
    }

    /**
     * Busca enemigos por su valor de vida
     * @param vida Puntos de vida del enemigo
     * @return Lista de enemigos que tienen la vida indicada
     */
    public List<Enemigo> buscarEnemigosPorVida(Integer vida)
    {
        return enemigoRepository.findByVida(vida);
    }

    /**
     * Obtiene estadísticas de un enemigo específico usando StatsDTO
     * @param nombre Nombre del enemigo
     * @return Lista de StatsDTO con nombre, vida y ataque
     */
    public List<StatsDTO> buscarStatsPorNombre(String nombre)
    {
        return enemigoRepository.findStatsByNombre(nombre);
    }

    /**
     * Obtiene la descripcion de un enemigo usando DescripcionDTO
     * Permite una visualizacion más limpia y personalizada
     * @param nombre Nombre del enemigo
     * @return Lista de DescripcionDTO con nombre, tipo y descripcion
     */
    public List<DescripcionDTO> buscarDescripcionPorNombre(String nombre)
    {
        return enemigoRepository.findDescripcionByNombre(nombre);
    }

    /**
     * Filtro enemigos considerados "Poderosos" segun los valores minimos de ataque
     * @param ataqueMin Ataque minimo requerido
     * @param vidaMin Vida minima requerida
     * @return Lista de StatsDTO que cumple con los parametros
     */
    public List<StatsDTO> obtenerStatsPoderosos(int ataqueMin, int vidaMin)
    {
        return enemigoRepository.filtrarEnemigosPoderosos(ataqueMin, vidaMin);
    }

}
