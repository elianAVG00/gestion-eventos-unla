# 🎓 Gestión de Eventos UNLa – MVP

Este proyecto es un **MVP (Producto Mínimo Viable)** para una aplicación de gestión de eventos institucionales en la Universidad Nacional de Lanús (UNLa). Fue desarrollado con **Java Spring Boot**, **MySQL** y con un frontend en **React**.

> ⚠️ Este sistema **no cubre todos los requisitos funcionales finales**. Su objetivo es construir una base funcional sobre la cual se puedan iterar futuras versiones más completas.

---

## 🚀 Tecnologías Utilizadas

- **Backend**: Java 17 + Spring Boot
- **Base de Datos**: MySQL 8+
- **ORM**: Spring Data JPA (Hibernate)
- **Build Tool**: Maven 3.8+
- **Otros**:
  - Lombok
  - Spring Security (configurada sin autenticación para pruebas)
  - Conectores MySQL y PostgreSQL (runtime)

---

## 📦 Estructura del Proyecto

```
gestion-eventos-unla/
├── backend/
│   ├── src/main/java/edu/unla/gestion_eventos/
│   ├── src/main/resources/application.properties
│   ├── src/main/resources/data.sql
```

---

## ⚙️ Requisitos del Sistema

1. **Java 17** – [Descargar](https://adoptium.net/es/temurin/releases/)
2. **Maven 3.8+** – [Descargar](https://maven.apache.org/download.cgi)
3. **MySQL Server 8+**

### Base de datos

Crear la base `eventosdb`:

```sql
CREATE DATABASE eventosdb;
```

> Usuario esperado: `root`  
> Contraseña esperada: `root`

---

## ▶️ Instrucciones para Ejecutar

```bash
# 1. Clonar el repositorio
git clone <repositorio>
cd gestion-eventos-unla/backend

# 2. Compilar
mvn clean install

# 3. Ejecutar
java -jar target/gestion-eventos-0.0.1-SNAPSHOT.jar
```

La aplicación quedará disponible en: [http://localhost:8080](http://localhost:8080)

---

## 🧪 Endpoints REST disponibles

Todos los controladores permiten acceso sin autenticación (fase MVP).

### 🌐 Departamentos – `/api/departamentos`
- `GET /api/departamentos` – Listar
- `GET /api/departamentos/{id}`
- `POST /api/departamentos`
- `PUT /api/departamentos/{id}`
- `DELETE /api/departamentos/{id}`

### 🧑 Usuarios – `/api/usuarios`
- `GET /api/usuarios`
- `GET /api/usuarios/{id}`
- `POST /api/usuarios`
- `PUT /api/usuarios/{id}`
- `DELETE /api/usuarios/{id}`

### 🏢 Espacios – `/api/espacios`
- `GET /api/espacios`
- `GET /api/espacios/disponibles`
- `GET /api/espacios/{id}`
- `POST /api/espacios`
- `PUT /api/espacios/{id}`
- `DELETE /api/espacios/{id}`

### 🎧 Recursos – `/api/recursos`
- `GET /api/recursos`
- `GET /api/recursos/disponibles`
- `GET /api/recursos/tipo/{tipo}`
- `GET /api/recursos/{id}`
- `POST /api/recursos`
- `PUT /api/recursos/{id}`
- `DELETE /api/recursos/{id}`

### 📅 Eventos – `/api/eventos`
- `GET /api/eventos`
- `GET /api/eventos/{id}`
- `POST /api/eventos`
- `PUT /api/eventos/{id}`
- `DELETE /api/eventos/{id}`

---

## 🧱 Modelo de Datos y Relaciones

Entidades principales:
- **Departamento**: nombre, color visual
- **Usuario**: nombre, email, rol (enum)
- **Espacio**: nombre, capacidad, ubicación, disponibilidad
- **Recurso**: nombre, tipo (AUDIO, VIDEO, PERSONAL), disponibilidad
- **Evento**: nombre, fechas, estado, solicitante, espacio, departamento, recursos asociados (M:N)

Relaciones:
- Departamento `1 - N` Usuario
- Departamento `1 - N` Evento
- Usuario `1 - N` Evento
- Espacio `1 - N` Evento
- Evento `M - N` Recurso (a través de tabla intermedia `evento_recursos`)

---

## 📌 Estado Actual – MVP

El MVP cubre los siguientes objetivos funcionales mínimos:

- ABM de todas las entidades (Eventos, Usuarios, Recursos, Espacios, Departamentos)
- Asociación de recursos a eventos
- Visualización básica de datos por API
- Sincronización automática con MySQL vía JPA
- Seguridad deshabilitada temporalmente (para facilitar pruebas iniciales)

---

## 📄 Requisitos Funcionales Futuro (Resumen)

Este MVP cubre solo parcialmente los requisitos globales. Las siguientes funcionalidades están pendientes:

- Calendario visual interactivo
- Validación automática de disponibilidad
- Gestión automática de respuestas (emails, confirmaciones)
- Roles con permisos diferenciados
- Reportes automáticos
- Comentarios técnicos por evento
- Plantillas de eventos frecuentes
- Filtros avanzados en calendario
- Interfaz responsive y mobile friendly

---

## 🛠️ Próximos pasos sugeridos

- Incorporar **seguridad por roles** (`SOLICITANTE`, `TECNICO`, `ADMIN_CEREMONIAL`)
- Desarrollar el **frontend en React**
- Implementar **validaciones DTO + separación de modelos**
- Agregar pruebas unitarias y de integración
- Modularizar servicios y lógica de negocio

---

## 📬 Contacto

Este proyecto fue desarrollado en contexto académico como parte de un trabajo integrador.  
