🐉 Bestiario — Sistema de Gestión de Criaturas

Aplicación full-stack desarrollada con Spring Boot (Java 21) y Frontend en JavaScript, HTML y CSS, que implementa una arquitectura basada en REST API para la gestión personalizada de criaturas dentro de un sistema tipo bestiario.

El sistema permite a los usuarios administrar criaturas, marcarlas como favoritas y agregar notas estratégicas asociadas, manteniendo persistencia individual por usuario.

🚀 Descripción General

Bestiario App es una aplicación orientada a demostrar:

Diseño de APIs REST bien estructuradas.

Modelado relacional con JPA / Hibernate.

Manejo de relaciones entre entidades.

Separación clara entre frontend y backend.

Aplicación de lógica matemática en filtros dinámicos.

Cada usuario posee su propio contexto de bestiario, evitando que el sistema sea un simple CRUD y convirtiéndolo en una aplicación con persistencia personalizada.

🏗 Arquitectura del Sistema

La aplicación sigue una arquitectura cliente-servidor:

Frontend (JavaScript + HTML + CSS)
                ↓
        REST API (Spring Boot)
                ↓
          MySQL Database

📌 Diagrama de Arquitectura

<img width="1293" height="582" alt="image" src="https://github.com/user-attachments/assets/ed499cdc-2be5-4b0b-b13d-2c197a2c18a5" />


📌 Funcionalidades Principales

🐲 Gestión de Criaturas (CRUD)

Crear criaturas.

Listar criaturas.

Consultar criatura por ID.

Actualizar información.

Eliminar registros.

⭐ Sistema de Favoritos por Usuario

Marcar y desmarcar criaturas como favoritas.

Persistencia individual por usuario.

Consulta dinámica de favoritos.

Relación muchos-a-muchos controlada mediante endpoints anidados.

📝 Notas Estratégicas

Agregar una nota personalizada por usuario y criatura.

Recuperar nota individual.

Endpoint estructurado con contexto de usuario.

🛠 Tecnologías Utilizadas
Backend

Java 21

Spring Boot

Spring Web (REST)

Spring Data JPA

Hibernate

Maven

MySQL

Frontend

JavaScript (ES6+)

HTML5

CSS3

🧠 Fundamentos Aplicados

El proyecto integra principios de lógica matemática y estructuración formal:

Operadores lógicos personalizados.

Filtros dinámicos combinados (AND / OR / NOT).

Modelado basado en relaciones y conjuntos.

Aplicación de condiciones compuestas en búsquedas.

Ejemplo de lógica soportada:

(fuerza > 10 AND tipo = "bestia") OR nivel < 3

Exclusión por conjuntos específicos.

Filtros combinados con múltiples parámetros.

🔌 Endpoints Principales
Criaturas
GET    /enemigos
GET    /enemigo/{id}
POST   /enemigos
PUT    /enemigos/{id}
DELETE /enemigos/{id}

Favoritos
POST   /usuarios/{id}/enemigos/{enemigoId}/favorito
DELETE /usuarios/{id}/enemigos/{enemigoId}/favorito
GET    /usuarios/{id}/favoritos

Notas
GET  /usuarios/{id}/enemigos/{enemigoId}/nota
POST /usuarios/{id}/enemigos/{enemigoId}/nota

🚀 Cómo Ejecutar el Proyecto
1️⃣ Clonar el repositorio
git clone https://github.com/qkarman/Bestiario.git

2️⃣ Configurar Backend

Importar el proyecto en tu IDE (IntelliJ / Eclipse).

Configurar application.properties con tus credenciales de MySQL.

Ejecutar:

mvn spring-boot:run


El servidor se iniciará en:

http://localhost:8081/bestiario-app

3️⃣ Ejecutar Frontend

Abrir el archivo principal HTML en el navegador o servirlo con una extensión tipo Live Server.

📈 Estado del Proyecto

En desarrollo activo.

Próximas mejoras:

✔ Mejora de interfaz visual.

✔ Nuevas categorías de criaturas.

⬜ Sistema de autenticación y autorización.

⬜ Exportación del bestiario a PDF.

⬜ Integración con generación automática de criaturas.

⬜ Despliegue en entorno productivo.

📄 Licencia

Este proyecto está bajo la licencia MIT.

👤 Autor

Qkarman
Desarrollador Backend
Interesado en arquitectura limpia, lógica formal aplicada y diseño estructurado de sistemas.
