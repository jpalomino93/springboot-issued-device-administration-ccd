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


Esto es el backend (El FeignClient)

curl --location 'https://dvi758vyde.execute-api.us-east-1.amazonaws.com/v1/system-auth/authentication-role/' \
--header 'x-financial-id: Interbak' \
--header 'x-end-user-terminal: consumer' \
--header 'x-request-id: 9f46f462-0cce-4949-ae6a-cc6610cff3b2' \
--header 'x-end-user-login: aplbipdev' \
--header 'x-end-user-request-date-time: 2025-12-10T05:57:07.609Z' \
--header 'x-channel: 1' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--header 'x-api-key: k1MXI2JO3r6HRNQJFGBQKaZjymAFvReU3LW7ZqjT' \
--data '{
"authentication": {
"login": "aplbipdev",
"password": "C0b1s2050*#"
},
"subsidiary": {
"code": 1
},
"branch": {
"code": 1
},
"role": {
"code": 3
}
}'



y esto sera mi apirest expuesta (se mapeare body y headers hacia el feigt client)

curl --location 'https://apic-gw-com.apps.ocpsbx.integracion.grupoib.local/ibk-dev/int-com-dev/issued-device-administration/v1/access-token-oauth2/create' \
--header 'x-api-key: mIEuAR4Z2l6jjJGuoxWNU13nuq7htpFU5J4Y5BlJ' \
--header 'x-financial-id: test' \
--header 'serviceId: LPC' \
--header 'consumerId: LPC' \
--header 'messageId: 8a0fac44-8d9f-48d6-824c-6b99fd51c8f3' \
--header 'timeStamp: 2022-11-11T09:57:00Z' \
--header 'netId: LP' \
--header 'userId: aplbipdev' \
--header 'supervisorId: X10438' \
--header 'deviceId: 10.11.37.72' \
--header 'branchId: 100' \
--header 'traceId: T-cc61a67e-c8a1-4706-93ba-d2a82ee3dfa8' \
--header 'parentId: P-4b03263a-cedb-4a2a-84b8-2fe1b58a7671' \
--header 'ipOrigen: 69.206.200.110' \
--header 'funcionalidadId: F225' \
--header 'Ocp-Apim-Subscription-Key: eda1fd8ecf105d8ca63065017192b5eb' \
--header 'Ocp-Apim-Subscription-Secret: 649dee1ecd376681d4dcdaa7beda3cf5' \
--header 'Content-Type: application/json' \
--data '{
"employeeIdentification": "aplbipdev1",
"employeePassword": "C0b1s2050*#",
"subsidiaryCode": 1,
"branchCode": 1,
"roleCode": 1
}'