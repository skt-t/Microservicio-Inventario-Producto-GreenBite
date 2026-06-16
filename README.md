# 🥬 Microservicio de Inventario - Ecosistema GreenBite

Este microservicio es responsable de la gestión del catálogo de productos y el control de stock dentro de la arquitectura de microservicios de **GreenBite**. Está diseñado para ser consumido a través de un patrón BFF (Backend For Frontend).

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 21 (LTS)
* **Framework:** Spring Boot 3.2.5
* **Persistencia:** Base de Datos H2 (En memoria) + Spring Data JPA
* **Gestión de Dependencias:** Maven
* **Testing:** JUnit 5 + Mockito + JaCoCo

## 🚀 Instrucciones de Ejecución

### 1. Compilación y Limpieza
Para limpiar construcciones previas y descargar las dependencias, ejecuta:
`mvn clean install`

### 2. Levantar el Servidor
Para iniciar el microservicio de forma local (se ejecutará en el puerto 8081 por defecto):
`mvn spring-boot:run`

### 3. Ejecución de Pruebas y Cobertura
El proyecto cuenta con pruebas unitarias aisladas. Para ejecutarlas y generar el reporte de cobertura de JaCoCo:
`mvn clean test`

*(El reporte HTML de cobertura se generará en la ruta: target/site/jacoco/index.html)*

## 📡 Especificación de la API (Endpoints)

La base de datos H2 es volátil. Al iniciar la aplicación, puedes poblarla utilizando los siguientes endpoints:

### 1. Crear un Producto (POST)
* **Ruta:** /api/productos
* **Body (JSON):**
{
  "nombre": "Tomate perita",
  "descripcion": "Tomate fresco de temporada",
  "precio": 1200.00,
  "stock": 100,
  "categoria": "Verduras",
  "imagenUrl": "https://ejemplo.com/tomate.png"
}

### 2. Listar Todo el Catálogo (GET)
* **Ruta:** /api/productos
* **Descripción:** Devuelve un arreglo JSON con todos los productos registrados.

### 3. Buscar Producto por Nombre (GET)
* **Ruta:** /api/productos/buscar?nombre=tomate
* **Descripción:** Búsqueda insensible a mayúsculas/minúsculas de productos que coincidan con el parámetro.

---
*Desarrollado para la Evaluación Parcial N°3 - Arquitectura de Microservicios.*
