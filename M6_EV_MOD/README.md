# 🛍️ API REST - Catálogo de Productos

> API REST construida con Spring Boot para gestionar un catálogo de productos

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8-blue.svg)](https://www.mysql.com/)

---

## 📋 Descripción

Este proyecto es una API REST construida con Spring Boot que expone un catálogo de productos para ser consumido por distintas aplicaciones cliente (aplicaciones web, móviles u otros servicios).

La API permite realizar operaciones CRUD sobre el recurso `Producto`, utilizando buenas prácticas REST, versionado de endpoints (`/api/v1`) y respuestas en formato JSON.

---

## 🛠️ Tecnologías

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 21 | Lenguaje de programación |
| Spring Boot | 3.5.6 | Framework principal |
| Spring Web | - | Controladores REST |
| Spring Data JPA | - | Acceso a datos |
| MySQL | 8 | Base de datos |
| Maven | - | Gestión de dependencias |

**Base de datos utilizada:** `gestion_productos` (ver archivo `script_productos.sql`)

---

## 📊 Modelo de Datos

### Entidad: `Producto`

```json
{
  "id": 1,
  "nombre": "Café molido",
  "descripcion": "500g tostado medio",
  "precio": 4500.0,
  "stockDisponible": 20
}
```

### Mapeo Entidad → Base de Datos

| Campo JSON | Campo BD | Tipo |
|------------|----------|------|
| `id` | `id` | BIGINT |
| `nombre` | `nombre` | VARCHAR |
| `descripcion` | `detalle` | VARCHAR |
| `precio` | `precio` | DOUBLE |
| `stockDisponible` | `cantidad` | INT |

---

## 🚀 Endpoints de la API

**Base URL:** `http://localhost:8080/api/v1/productos`

### 📋 Listar todos los productos

```http
GET /api/v1/productos
```

**Respuesta:** `200 OK`

```json
[
  {
    "id": 1,
    "nombre": "Café molido",
    "descripcion": "500g tostado medio",
    "stockDisponible": 20,
    "precio": 4500.0
  },
  {
    "id": 2,
    "nombre": "Té verde",
    "descripcion": "Caja 20 bolsas",
    "stockDisponible": 35,
    "precio": 2500.0
  }
]
```

---

### 🔍 Obtener un producto por ID

```http
GET /api/v1/productos/{id}
```

**Respuestas:**
- `200 OK` - Producto encontrado
- `404 Not Found` - Producto no existe

---

### ➕ Crear un nuevo producto

```http
POST /api/v1/productos
Content-Type: application/json
```

**Body:**

```json
{
  "nombre": "Café molido",
  "descripcion": "500g tostado medio",
  "stockDisponible": 20,
  "precio": 4500.0
}
```

**Respuesta:** `201 Created` (producto creado con su ID generado)

---

### ✏️ Actualizar un producto

```http
PUT /api/v1/productos/{id}
Content-Type: application/json
```

**Body:**

```json
{
  "nombre": "Café molido especial",
  "descripcion": "500g tostado medio premium",
  "stockDisponible": 15,
  "precio": 5500.0
}
```

**Respuesta:** `200 OK`

---

### 🗑️ Eliminar un producto

```http
DELETE /api/v1/productos/{id}
```

**Respuesta:** `204 No Content`

---

## 🌐 CORS e Interoperabilidad

El controlador REST (`ProductoRestController`) utiliza:

```java
@CrossOrigin(origins = "*")
```

Esto permite que la API sea consumida desde aplicaciones cliente ubicadas en otros dominios o puertos (por ejemplo, un frontend en `http://localhost:3000`), cumpliendo con el requisito de interoperabilidad mediante CORS.

---

## 📁 Estructura del Proyecto

```
com.skillnest.web
├── 📦 models
│   └── Producto.java              # Entidad JPA
├── 📦 repository
│   └── ProductoRepository.java    # Interfaz JPA Repository
├── 📦 services
│   ├── ProductoService.java       # Interfaz de servicio
│   └── ProductoServiceImpl.java   # Implementación lógica de negocio
└── 📦 restControllers
    └── ProductoRestController.java # Endpoints REST
```

---

## ⚙️ Configuración y Ejecución

### 1️⃣ Crear la base de datos

Ejecutar el script SQL en MySQL:

```bash
mysql -u root -p < script_productos.sql
```

### 2️⃣ Configurar `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_productos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 3️⃣ Ejecutar la aplicación

**Desde el IDE:**
```
Ejecutar la clase: HolaMundoApplication.java
```

**Desde la terminal:**
```bash
mvn spring-boot:run
```

---

## 🧪 Probar la API

Puedes probar la API con Postman (u otra herramienta HTTP):

- `GET http://localhost:8080/api/v1/productos`
- `POST http://localhost:8080/api/v1/productos`
- `PUT http://localhost:8080/api/v1/productos/1`
- `DELETE http://localhost:8080/api/v1/productos/1`

La API responde en formato JSON y está lista para ser consumida por distintas aplicaciones cliente.

---

## 👨‍💻 Autor

**Manuel Ibarra**

*Proyecto desarrollado como parte del Bootcamp de SkillNest*