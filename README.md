# CineApp Backend - MongoDB

Sistema de administración de cine con Spring Boot 3.4.5 y MongoDB.

## Stack Tecnológico

- **Java 21**
- **Spring Boot 3.4.5**
- **MongoDB Atlas** (cloud)
- **JWT** Authentication
- **Cloudinary** (imágenes)
- **Ethereal Email** (testing)
- **Docker** + **Fly.io** (deploy)

## Requisitos

- Java 21+
- Maven 3.8+
- Docker (para desarrollo local)

## Configuración

### Variables de Entorno

Crear archivo `.env` en la raíz del proyecto:

```env
MONGODB_URI=mongodb://localhost:27017/cine
JWT_SECRET=development-secret-key-min-32-chars-here
JWT_EXPIRATION=86400000
SMTP_HOST=smtp.ethereal.email
SMTP_PORT=587
```

### Desarrollo Local

```bash
# Compilar
./mvnw compile

# Ejecutar
./mvnw spring-boot:run

# Con Docker
docker-compose up -d
```

## API Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /api/auth/register | Registro de usuario |
| POST | /api/auth/login | Login |
| GET | /api/auth/profile | Perfil (auth) |
| GET | /api/movies | Listar películas |
| POST | /api/movies | Crear película (admin) |
| GET | /api/rooms | Listar salas |
| POST | /api/rooms | Crear sala (admin) |
| GET | /api/showtimes | Listar funciones |
| POST | /api/showtimes | Crear función (admin) |
| POST | /api/purchases | Crear compra |

## Admin por Defecto

- **Email**: admin@cine.com
- **Contraseña**: Admin1234

## Deploy

```bash
# Build imagen
docker build -t usuario/cine-app-back-mongo:latest .

# Push a Docker Hub
docker push usuario/cine-app-back-mongo:latest

# Deploy en Fly.io
fly launch --image usuario/cine-app-back-mongo:latest
fly secrets set MONGODB_URI="mongodb+srv://..."
fly secrets set JWT_SECRET="your-secret"
```

## Documentación

Ver [documentacion/plan-back-mongo.md](documentacion/fases/plan-back-mongo.md) para el plan completo de desarrollo.