package com.cristian.bestiario.Service;

import com.cristian.bestiario.entity.Enemigo; //la entidad que se esta gestionando
import com.cristian.bestiario.repository.EnemigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
/*
Esta clase es quien ejecuta la logica del negocio, apoyándose en el repositorio para comunicarse con la base de datos
al implementar IEnemigoService, garantiza que ofrece las funciones basicas: listar, buscar, guardar y eliminar enemigos
 */


//? Le dice a Spring que esta clase debe ser gestionada como un componente de servicio, asi podra inyectar
//? en otras partes del sistema como en los controladores y se implementa los metodos de la interfaz
@Service
public class EnemigoService implements IEnemigoService
{
    //Inyecta una instancia del repositorio EnemigoRepository para acceder a los datos de la base de datos
    //y Spring se encarga de instanciarlos automáticamente gracias a @Autowired
    @Autowired
    private EnemigoRepository enemigoRepository;

    //*Recupera todos los enemigos almacenados en la base de datos usando el metodo findAll() que viene de JpaRepository
    @Override
    public List<Enemigo> listarEnemigos()
    {
        return this.enemigoRepository.findAll();
    }

    //*Busca un enemigo por su ID
    @Override
    public Enemigo buscarEnemigoId(Integer idEnemigo)
    {
        Enemigo enemigo = this.enemigoRepository.findById(idEnemigo).orElse(null);
        return enemigo;
    }

    //*Guarda un enemigo o actualiza uno existente(si ya tiene ID)
    @Override
    public Enemigo guardarEnemigo(Enemigo enemigo)
    {
        return this.enemigoRepository.save(enemigo);
    }

    //*Elimina el enemigo con el ID especificado
    @Override
    public void eliminarEnemigoId(Integer idEnemigo)
    {
        this.enemigoRepository.deleteById(idEnemigo);
    }

    //¡Implementation de los filtros

    //! Implementamos el metodo del filtro PRUEBA
    public List<Enemigo> buscarEnemigosPorTipo(String tipo)
    {
        return enemigoRepository.findByTipo(tipo);
    }

    //! Implementamos el metodo del filtro Nombre, Vida y ataque
    public List<Enemigo> buscarEnemigosPorVida(Integer vida)
    {
        return enemigoRepository.findByVida(vida);
    }

}
