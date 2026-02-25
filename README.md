# 🐉 Bestiario — Sistema de Gestión de Criaturas

Proyecto desarrollado por **Cristian Flores**, pensado como parte de un portafolio profesional.
El sistema permite **agregar, editar, eliminar y consultar enemigos** inspirados en juegos como *Calabozos y Dragones*.

Este proyecto está dividido en **backend (Spring Boot)** y **frontend (Angular)**, utilizando bases de datos **MySQL** y principios de lógica matemática para filtros y búsquedas avanzadas.

---

## 📌 Características principales

* 📚 Registro completo de enemigos (nombre, tipo, estadísticas, atributos).
* 🔍 Filtros inteligentes basados en:

  * lógica proposicional
  * tablas de verdad
  * teoría de conjuntos
* 🧮 Búsquedas optimizadas usando modelos matemáticos.
* 🗃 Persistencia en MySQL con conexión mediante DBeaver.
* ⚙ Arquitectura orientada a ser un proyecto escalable para portafolio.
* 🎨 Frontend en Angular con una interfaz visual clara y agradable.

---

## 🛠 Tecnologías Utilizadas

### **Backend**

* Java 21
* Spring Boot (REST API)
* Maven
* MySQL
* JPA / Hibernate

### **Frontend**

* Angular
* TypeScript
* HTML / CSS

---

## 🚀 Cómo Ejecutarlo

### **1. Clonar el repositorio**

```
git clone https://github.com/crisflores23/bestiario.git
```

### **2. Backend**

* Importar proyecto Spring Boot.
* Configurar `application.properties` con tu MySQL.
* Ejecutar la app:

```
mvn spring-boot:run
```

### **3. Frontend**

```
cd frontend/
npm install
ng serve
```

---

## 🧠 Lógica y Matemáticas Aplicadas

Este proyecto integra ideas de:

* **Tablas de verdad**
* **Operaciones de conjuntos**
* **Lógica de primer orden**
* **Filtros por operadores lógicos custom**

Esto permite búsquedas como:

* enemigos que cumplan **(fuerza > 10 Y tipo = “bestia”) O nivel < 3**
* enemigos que NO pertenezcan a ciertos grupos

---

## 📌 Estado del Proyecto

En desarrollo activo.
Se planea integrar:

* ✔ Mejor UI en Angular
* ✔ Nuevas categorías de enemigos
* ⬜ Sistema de autenticación
* ⬜ Exportación del bestiario a PDF
* ⬜ Integración con IA para generación automática de enemigos

---

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**.

---

## 👤 Autor

**Cristian Flores**
Desarrollador Backend
Inspirado por modelos matemáticos y diseño limpio de software.
