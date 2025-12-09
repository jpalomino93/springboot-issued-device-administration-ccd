# 🚀 Spring Boot Template (MVC) — Java 21 | Spring Boot 3

Plantilla profesional para crear nuevos proyectos Spring Boot utilizando una arquitectura limpia, moderna y mantenible.  
Este repositorio está configurado como **Template Repository**, permitiéndote generar microservicios rápidamente sin tener que empezar desde cero.

---

## ✨ Características principales

- **Java 21**
- **Spring Boot 3 (MVC tradicional)**
- **API REST documentada con Swagger (OpenAPI 3)**
- **Spring Data JPA + Hibernate**
- **PostgreSQL (compatible con docker-compose)**
- **Validaciones con Jakarta Validation**
- **MapStruct para mapeo de DTOs**
- **Lombok para reducir código boilerplate**
- **Global Exception Handler**
- **Estructura profesional y escalable**
- **Dockerfile listo para producción**
- **docker-compose con PostgreSQL preconfigurado**

---

## 📁 Estructura del proyecto

```
springboot-template-mvc/
 ├── pom.xml
 ├── Dockerfile
 ├── docker-compose.yml
 ├── README.md
 ├── src
 │   ├── main
 │   │   ├── java/com/example/template
 │   │   │   ├── TemplateApplication.java
 │   │   │   ├── config/
 │   │   │   ├── controller/
 │   │   │   ├── dto/
 │   │   │   ├── entity/
 │   │   │   ├── exception/
 │   │   │   ├── mapper/
 │   │   │   ├── repository/
 │   │   │   └── service/
 │   │   └── resources/application.yml
 │   └── test/java/...
```

---

## 🧩 Tecnologías utilizadas

| Componente     | Tecnología / Librería |
|----------------|------------------------|
| Lenguaje       | Java 21               |
| Framework      | Spring Boot 3.x (MVC) |
| Documentación  | Springdoc OpenAPI     |
| ORM            | Hibernate / JPA       |
| Base de Datos  | PostgreSQL            |
| Build System   | Maven                 |
| Mappers        | MapStruct             |
| Utilidades     | Lombok                |
| Contenedores   | Docker + docker-compose |

---

## ▶️ Cómo ejecutar el proyecto

### 1️⃣ Levantar PostgreSQL con Docker Compose

Ejecuta:

```bash
docker-compose up -d
```

Esto crea una base de datos con:

- Base de datos: `demo_db`
- Usuario: `demo`
- Password: `demo`

---

### 2️⃣ Ejecutar la aplicación Spring Boot

```bash
mvn spring-boot:run
```

---

### 3️⃣ Probar la API

**Health Check**

```
GET http://localhost:8080/api/users/health
```

**Listar usuarios**

```
GET http://localhost:8080/api/users
```

**Crear usuario**

```
POST http://localhost:8080/api/users
Content-Type: application/json

{
  "name": "José Miguel",
  "email": "jmiguel@example.com"
}
```

---

## 📘 Documentación OpenAPI

Swagger UI:  
👉 http://localhost:8080/swagger-ui/index.html

---

## 🧱 Arquitectura incluida

Esta plantilla incluye:

- `UserController`
- `UserService`
- `UserRepository`
- Entidad `User`
- DTOs (`UserRequest`, `UserResponse`)
- `UserMapper` (MapStruct)
- `GlobalExceptionHandler`

---

## 🐳 Dockerfile para producción

```
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

---

## 🎯 Roadmap sugerido

- Autenticación JWT
- Manejo de logs estructurados
- Versionamiento de APIs
- Validaciones avanzadas
- Tests unitarios + integración
- CI/CD con GitHub Actions
- Integración con Kafka o RabbitMQ
- Arquitectura hexagonal o DDD

---

## 🤝 Contribución

Este repositorio es una plantilla personal. Puedes ampliarlo o adaptarlo según tus necesidades.

---

## 📄 Licencia

MIT — Libre para uso personal y comercial.

---

## 👨‍💻 Autor

**José Miguel Palomino**  
GitHub: https://github.com/jpalomino93

---

## 🌟 ¿Cómo reutilizar este template?

1. Ir a este repositorio en GitHub.
2. Click en **“Use this template”**.
3. Crear un nuevo repositorio basado en él.
4. ¡Listo! Un microservicio Spring Boot listo para usar.
