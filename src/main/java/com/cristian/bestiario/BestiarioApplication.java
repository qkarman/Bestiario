package com.cristian.bestiario;

import org.springframework.boot.SpringApplication; //Lanza la app
import org.springframework.boot.autoconfigure.SpringBootApplication; //Indica que esta es la clase principal

/**
 * Esta es la clase principal de la aplicacion bestiario
 * su funcion es iniciar el servidor de Sprint Boot y levantar el contexto de la app
 * también puede usarse para ejecutar código de prueba al inicio (CommandLineRunner
 */

//Indica que esta clase es la principal de configuracion de Spring Boot
@SpringBootApplication
public class BestiarioApplication
{
	//Metodo main -> Punto de la aplicacion
	//Aquí se arranca el servidor embebido (Tomcat) y el contexto de Spring
	public static void main(String[] args)
	{
		SpringApplication.run(BestiarioApplication.class, args);
	}

	//*Este metodo crea un bean que implementa CommandLineRunner
	//*Se ejecuta una sola vez al inicio de la app
	//*Recibe como parametro el EnemigoRepository para poder guardar un enemigo en la base de datos
	//@Bean
	//public CommandLineRunner init(EnemigoRepository enemigoRepository)
	//{
		//Aqui se crea un objeto Enemigo y se le asignas sus atributos mediante los setters
		//return args ->
		//{
			/*
			Enemigo enemigo = new Enemigo();
			enemigo.setNombre("Orco");
			enemigo.setTipo("Oscuridad");
			enemigo.setVida(10);
			enemigo.setAtaque(2);
			enemigo.setHabilidad("Hachazo");
			enemigo.setDescripcion("Orco de los montes");
			 */


			//enemigoRepository.save(enemigo); //Se guarda el enemigo en la base de datos

			//Imprimir el objeto se llama con toString de lombok
			//System.out.println(enemigo);
		//};
	//}
}
