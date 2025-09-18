package com.cristian.bestiario;

import org.springframework.boot.SpringApplication; //Lanza la app
import org.springframework.boot.autoconfigure.SpringBootApplication; //Indica que esta es la clase principal


/*
Esta clase inicia el servidor Spring Boot, crea a un enemigo, lo guarda en la base de datos
y luego lo imprime en consola
 */

//Indica que es la clase principal
@SpringBootApplication
public class BestiarioApplication
{
	//Indica el metodo main
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
