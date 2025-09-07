# cafetera-backend

## Proyecto Formativo
**Plataforma Avanzada de Integración Tecnológica**

---

## Tecnologías Utilizadas

- **Lenguaje**: Java 17  
- **Framework**: Spring Boot 3.5.5  
- **Base de Datos**: MongoDB (local)  
- **IDE**: Visual Studio Code  
- **Versionamiento**: Git y GitHub  
- **Gestor de dependencias**: Maven  

---

## Estructura del Proyecto

- `entity/Productor.java`: Clase con anotaciones de validación.  
- `repository/ProductorRepository.java`: Interfaz MongoRepository.  
- `controller/ProductorController.java`: Controlador REST con validaciones.  
- `resources/application.properties`: Configuración de conexión a MongoDB.  

---

## Validaciones Implementadas

- `@NotBlank`: Campo obligatorio.  
- `@Size`: Longitud mínima y máxima.  
- `@Email`: Formato de correo electrónico.  
- `@Pattern`: Validación de número telefónico (10 dígitos).  

---

## Pruebas con Postman

### Datos válidos, a modo de ejemplo para crear un nuevo productor

**POST** `http://localhost:8080/api/productores`
json { "nombre": "Juan Pérez", "correo": "juan@example.com", "telefono": "3123456789" }
**Resultado esperado**:  
- Código HTTP: `200 OK`  
- Registro almacenado en MongoDB  
- Verificación en MongoDB Compass

---

### ❌ Datos inválidos
json { "nombre": "", "correo": "correo_invalido", "telefono": "123" } ```
Resultado esperado: 
•	Código HTTP: 400 Bad Request 
•	Mensajes de error:
o	El nombre es obligatorio
o	Correo electrónico inválido
o	El teléfono debe tener 10 dígitos
