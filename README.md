# 🐉 Bestiario

Proyecto **CRUD de enemigos** para un juego tipo **Dungeons & Dragons (DnD)**.  
Desarrollado en **Java 21** con **Spring Boot 3.5.4**, **JPA/Hibernate** y **MySQL**.

---

## 🚀 Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **Spring Web**
- **MySQL** (conector mysql-connector-j)
- **Lombok**
- **Maven**

---

## ⚙️ Instalación y ejecución

1.- Clonar el repositorio:
   ```
   git clone https://github.com/tu-usuario/bestiario.git
   cd bestiario
   ```

2.- Configurar la base de datos en src/main/resources/application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bestiario
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

3.- Compilar y ejecutar con Maven:
```
mvn spring-boot:run
```
4.- La aplicación correrá en:
```
http://localhost:8080
```

## 📌 Endpoints principales
Enemigos

GET /enemigos → Listar todos los enemigos

GET /enemigos/{id} → Ver enemigo por ID

POST /enemigos → Crear enemigo

PUT /enemigos/{id} → Modificar enemigo

DELETE /enemigos/{id} → Eliminar enemigo

Usuarios y Favoritos

POST /usuarios/{idUsuario}/favoritos/{idEnemigo} → Toggle de favoritos

GET /usuarios/{idUsuario}/favoritos → Ver lista de favoritos


## Notas

POST /notas/{idUsuario}/{idEnemigo} → Crear o modificar nota

GET /notas/{idUsuario}/{idEnemigo} → Ver nota

DELETE /notas/{idUsuario}/{idEnemigo} → Eliminar nota

POST /enemigos
{
  "nombre": "Orco",
  "tipo": "Oscuridad",
  "vida": 10,
  "ataque": 2,
  "habilidad": "Hachazo",
  "descripcion": "Orco de los montes"
}

## 👤 Autor

Cristian Flores
Proyecto desarrollado como práctica de Java + Spring Boot + MySQL
