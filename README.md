# Sistema de Evaluación de Actividades

## Descripción del Proyecto

Esta aplicación web desarrollada en Spring Boot permite la gestión y evaluación de actividades recreativas. El sistema incluye funcionalidades para evaluar actividades terminadas, administrar fotos asociadas y mantener un registro de actividades del sistema.

## Funcionalidades Implementadas

### 1. Sistema de Evaluación de Actividades
- Listado de actividades realizadas (fecha de término anterior a la actual)
- Evaluación de actividades mediante notas del 1 al 7
- Cálculo automático de promedios de evaluación
- Interfaz asíncrona utilizando JavaScript y API REST

### 2. Administrador de Fotos
- **URL**: `/admin/fotos`
- Galería visual de fotografías asociadas a actividades
- Funcionalidad de eliminación con confirmación
- Campo obligatorio para justificar la eliminación (máximo 200 caracteres)
- Registro automático de acciones en el sistema de logs

### 3. Sistema de Logs
- **URL**: `/log`
- Registro cronológico de actividades del sistema
- Ordenamiento por fecha descendente
- Visualización de acciones administrativas y del sistema

## Tecnologías Utilizadas

### Backend
- **Spring Boot 3.5.3** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **Hibernate** - ORM para base de datos
- **Spring MVC** - Arquitectura web
- **Maven** - Gestión de dependencias

### Frontend
- **Thymeleaf** - Motor de plantillas
- **Bootstrap 5** - Framework CSS
- **JavaScript ES6** - Funcionalidad del lado del cliente
- **Fetch API** - Comunicación asíncrona

### Base de Datos
- **H2 Database** - Base de datos en memoria para desarrollo
- **JPA/Hibernate** - Mapeo objeto-relacional

## Estructura del Proyecto

### Entidades
- `Actividad` - Gestión de actividades recreativas
- `Nota` - Sistema de evaluaciones
- `Foto` - Administración de imágenes
- `Log` - Registro de actividades del sistema
- `Region` y `Comuna` - Datos geográficos

### Repositorios
- `ActividadRepository` - Operaciones CRUD para actividades
- `NotaRepository` - Gestión de evaluaciones
- `FotoRepository` - Administración de fotografías
- `LogRepository` - Manejo de registros del sistema

### Servicios
- `ActividadService` - Lógica de negocio para actividades
- `AdminService` - Funcionalidades administrativas

### Controladores
- `ActividadController` - Endpoints principales
- `AdminController` - Funcionalidades de administración

## Configuración y Ejecución

### Prerrequisitos
- Java 17 o superior
- Maven 3.6 o superior

### Instalación y Ejecución
1. Clonar el repositorio
2. Navegar al directorio del proyecto
3. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```
4. Acceder a la aplicación en `http://localhost:8081`

### URLs Disponibles
- `/` - Página principal con evaluación de actividades
- `/admin/fotos` - Administrador de fotografías
- `/log` - Registro de actividades del sistema
- `/api/actividad/{id}/nota` - API REST para agregar evaluaciones
- `/api/foto/{id}` - API REST para eliminar fotografías

## Funcionalidades Técnicas

### Validaciones Implementadas
- Notas entre 1 y 7 (validación cliente y servidor)
- Motivo de eliminación obligatorio (máximo 200 caracteres)
- Verificación de existencia de recursos antes de operaciones

### Características de Seguridad
- Validación de entrada en formularios
- Sanitización de datos antes de persistencia
- Manejo de errores y excepciones

### Características de Usabilidad
- Interfaz responsiva adaptable a dispositivos móviles
- Retroalimentación visual para acciones del usuario
- Confirmaciones para operaciones críticas

## Base de Datos

### Estructura de Tablas
- `actividad` - Información de actividades
- `nota` - Evaluaciones de actividades
- `foto` - Registro de fotografías
- `log` - Historial de actividades del sistema
- `region` y `comuna` - Datos geográficos

### Datos de Prueba
La aplicación inicia con la base de datos vacía. Para probar las funcionalidades:
- Las actividades deben ser insertadas manualmente en la base de datos
- Solo las actividades con fecha de término anterior a la actual aparecerán en la interfaz
- El sistema de logs registrará automáticamente las acciones administrativas

## Consideraciones de Desarrollo

### Arquitectura
- Patrón MVC (Model-View-Controller)
- Separación de responsabilidades
- Inyección de dependencias con Spring

### Mejores Prácticas
- Código documentado y comentado
- Manejo centralizado de excepciones
- Transacciones para operaciones críticas
- Logging automático de actividades administrativas

## Estructura de Archivos

```
src/
├── main/
│   ├── java/com/tarea4/tarea4/
│   │   ├── controller/
│   │   │   ├── ActividadController.java
│   │   │   └── AdminController.java
│   │   ├── entity/
│   │   │   ├── Actividad.java
│   │   │   ├── Nota.java
│   │   │   ├── Foto.java
│   │   │   └── Log.java
│   │   ├── repository/
│   │   │   ├── ActividadRepository.java
│   │   │   ├── NotaRepository.java
│   │   │   ├── FotoRepository.java
│   │   │   └── LogRepository.java
│   │   ├── service/
│   │   │   ├── ActividadService.java
│   │   │   └── AdminService.java
│   │   └── Tarea4Application.java
│   └── resources/
│       ├── static/
│       │   ├── css/
│       │   │   ├── base.css
│       │   │   ├── table.css
│       │   │   ├── buttons.css
│       │   │   ├── modal.css
│       │   │   └── admin.css
│       │   └── js/
│       │       ├── evaluacion.js
│       │       └── admin-fotos.js
│       └── templates/
│           ├── index.html
│           ├── admin/
│           │   └── fotos.html
│           └── log.html
```

---

**Desarrollado con Spring Boot Framework**  
**Fecha de última actualización: Julio 2025**
