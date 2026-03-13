# 👔 Sistema de Alquiler y Gestión de Prendas (Tintorería)

Este proyecto es una API REST robusta desarrollada con **Spring Boot 3.4** y **Java 21**, diseñada para gestionar el ciclo de vida de prendas en un negocio de alquiler y lavandería.

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen.svg)](https://spring.io/projects/spring-boot)

## 🚀 Características y Patrones de Diseño

El sistema destaca por el uso de arquitectura limpia y patrones de diseño avanzados:
- **Patrón State:** Gestiona los estados de las prendas (`Disponible`, `Alquilada`, `En Lavado`) de forma dinámica, encapsulando la lógica de transición y evitando condicionales complejos.
- **Patrón Strategy:** Implementa diferentes algoritmos para la prioridad de limpieza de prendas (ej. `PrendasPorPrioridadYFechaStrategy`).
- **Herencia en JPA:** Uso de la estrategia `JOINED` para gestionar diferentes tipos de prendas (`Vestido`, `Traje`, `Disfraz`) manteniendo la integridad de la base de datos.

---

## 🛠️ Requisitos para la Ejecución

Para ejecutar este proyecto localmente, asegúrate de cumplir con lo siguiente:

1.  **Java Development Kit (JDK) 21:** Es obligatorio, ya que se utilizan características modernas como *Records* y mejoras en la inferencia de tipos para *Streams*.
2.  **Maven 3.9+:** Para la gestión de dependencias y construcción del proyecto.
3.  **Base de Datos:** * Por defecto, el proyecto está configurado para **H2** (en memoria) para facilitar las pruebas.
    * Configuración configurable en `src/main/resources/application.properties`.
4.  **Lombok:** Es necesario tener habilitado el *Annotation Processing* en tu IDE.

---

## 🔧 Instalación y Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/DiegoFerBZ/tintoreria.git](https://github.com/DiegoFerBZ/tintoreria.git)
    cd tintoreria
    ```

2.  **Limpiar y Compilar:**
    Ejecuta el siguiente comando para limpiar el caché de Maven y generar las clases de Lombok:
    ```bash
    mvn clean install
    ```

3.  **Ejecutar la aplicación:**
    ```bash
    mvn spring-boot:run
    ```

La API estará disponible en: `http://localhost:8080`

---

## 📖 Documentación de la API (Swagger)

Una vez iniciada la aplicación, puedes explorar y probar los endpoints desde la interfaz interactiva de Swagger UI:

🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🏗️ Estructura del Proyecto

* `model`: Entidades JPA y lógica del **Patrón State**.
* `dtos`: Objetos de transferencia de datos (usando *Records*).
* `services`: Lógica de negocio y aplicación del **Patrón Strategy**.
* `controllers`: Endpoints REST expuestos.
* `repository`: Interfaces de Spring Data JPA con optimizaciones de carga