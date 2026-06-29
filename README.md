# CropCare API

API REST en Java/Spring Boot para el catálogo de especies de plantas domésticas de la aplicación móvil **CropCare**. Proporciona endpoints CRUD para especies y consulta de factores de ajuste climático.

## Requisitos

- Java 17 o superior
- Maven 3.8+
- (Opcional) PostgreSQL 14+ para desarrollo local con base de datos persistente

## Ejecución local

### Opción 1: H2 en memoria (recomendado para desarrollo rápido)

```bash
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080`.

### Opción 2: PostgreSQL local

1. Crea una base de datos llamada `cropcare` en PostgreSQL.
2. Configura las variables de entorno (opcional, los valores por defecto son `postgres`/`postgres`):

```bash
export DB_USERNAME=postgres
export DB_PASSWORD=tu_password
```

3. Ejecuta con el perfil `local-postgres`:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local-postgres
```

### Compilar y empaquetar

```bash
./mvnw clean package
java -jar target/cropcare-api-1.0.0.jar
```

## Swagger UI

Con la aplicación en ejecución, abre:

- **Local:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Producción (Render):** `https://<nombre-de-tu-servicio>.onrender.com/swagger-ui.html`

## Endpoints principales

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/api/species` | Listar todas las especies |
| GET | `/api/species/{id}` | Obtener especie por ID |
| GET | `/api/species/search?nombre={texto}` | Buscar por nombre común |
| POST | `/api/species` | Crear especie |
| PUT | `/api/species/{id}` | Actualizar especie |
| DELETE | `/api/species/{id}` | Eliminar especie |
| GET | `/api/climate-factors` | Listar factores climáticos |
| GET | `/api/climate-factors/tipo/{tipoFactor}` | Filtrar por tipo |

Al iniciar por primera vez, se cargan automáticamente **22 especies** y **10 factores climáticos** si las tablas están vacías.

## Despliegue en Render

### Paso 1: Preparar el repositorio

1. Sube el proyecto a un repositorio en GitHub.
2. Asegúrate de incluir el wrapper de Maven (`mvnw`, `mvnw.cmd`, `.mvn/`).

### Paso 2: Crear cuenta y conectar repositorio

1. Regístrate en [Render](https://render.com).
2. En el dashboard, selecciona **New → Blueprint**.
3. Conecta tu repositorio de GitHub y Render detectará el archivo `render.yaml`.

### Paso 3: Desplegar con Blueprint (Infrastructure as Code)

El archivo `render.yaml` define:

- Un **Web Service** con runtime **Docker** (plan gratuito) que compila con Maven y ejecuta el JAR vía `Dockerfile`.
- Una base de datos **PostgreSQL** gratuita vinculada al servicio.

> **Nota:** Render no tiene runtime nativo `java`. Las apps Spring Boot deben desplegarse con `runtime: docker`.

Render configurará automáticamente:

- `SPRING_PROFILES_ACTIVE=production`
- `DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD` (desde la base de datos)
- `PORT` (puerto dinámico de Render)

### Paso 4: Despliegue manual (alternativa)

Si prefieres configurar manualmente:

1. **New → PostgreSQL** → crea la base `cropcare-db` (plan free).
2. **New → Web Service** → conecta el repositorio.
3. Configura:
   - **Runtime:** Docker
   - Render detectará el `Dockerfile` en la raíz del proyecto.
4. En **Environment**, añade:
   - `SPRING_PROFILES_ACTIVE` = `production`
   - Vincula la base PostgreSQL (Render inyectará `DATABASE_URL`, usuario y contraseña).

### Paso 5: Verificar el despliegue

1. Espera a que el build termine (puede tardar varios minutos en el plan gratuito).
2. Abre la URL del servicio: `https://<nombre-app>.onrender.com/api/species`
3. Verifica Swagger: `https://<nombre-app>.onrender.com/swagger-ui.html`

> **Nota:** En el plan gratuito de Render, el servicio entra en suspensión tras inactividad. La primera petición puede tardar 30–60 segundos en responder.

## Estructura del proyecto

```
com.cropcare.api
├── config/          # CORS, OpenAPI, configuración Render DB
├── controller/      # REST controllers
├── service/         # Lógica de negocio
├── repository/      # Spring Data JPA
├── entity/          # Entidades JPA
├── dto/             # Objetos de transferencia
├── mapper/          # Conversión Entity ↔ DTO
├── exception/       # Manejo global de errores
└── seed/            # Datos iniciales
```

## Variables de entorno

| Variable | Descripción | Entorno |
|----------|-------------|---------|
| `SPRING_PROFILES_ACTIVE` | Perfil activo (`h2`, `local-postgres`, `production`) | Todos |
| `DATABASE_URL` | URL de conexión PostgreSQL | Producción |
| `DATABASE_USERNAME` | Usuario de la base de datos | Producción |
| `DATABASE_PASSWORD` | Contraseña de la base de datos | Producción |
| `PORT` | Puerto del servidor (Render lo inyecta) | Producción |
| `DB_USERNAME` / `DB_PASSWORD` | Credenciales PostgreSQL local | Desarrollo |

## Licencia

Proyecto académico — CropCare.
