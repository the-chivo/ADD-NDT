# Tema 8

#  Implementación de APIs en java

## 1. Controllers

 - En Spring Boot para construir una API necesitamos un controlador
 - Un controlador de Spring Boot es una clase que se va a encargar de manejar las peticiones HTTP
 - Esta clase se identifica por la anotación @RestController

```
@RestController
public class PeliculaController{
  
}

```

## 2. RequestMapping

- Es una anotación de Spring Boot que nos permite definir el recurso que va a gestiona un determinado controlador
- Encima de la defición de la clase pondremos @RequestMapping(String nombreRecurso)
- Donde "String nombreRecurso" es un String que debemos poner indicando el nombre del recurso


### Ejemplo de controlador de peliculas

```
@RestController
@RequestMapping("/peliculas")
public class PeliculaController{
  
}

```

### Buenas practicas a la hora de combinar recursos:

- Uso de sustantivos
- Uso de letras en minuscula
- Evitar el uso de caracteres especiales
- Separar las palabras por "-"

## 3.Servicios en controladores

### En los controladores utilizaremos los servicios para insertar, borrar, actualizar y obtener datos.

```
@RestController
@RequestMapping("/peliculas")
public class PeliculaController{
  @Autowired
  private PeliculaService peliculaService;
}
```

## 4. Objeto responseEntity

- Para devolver esta información tenemos el objeto "reponseEntity" de Spring Boot
- Acepta uno o dos párametros en funciómn de si queremos devolver:

- Estados HTTP/Datos o Estado HTTP

-Todos los metodos de los controladores deberán devolver algo similar a una de as dos siguientes opciones(ejemplo):

### Estado HTTP/Datos

```
return new ResponseEntity<>(id, HttpStatus.CREATED);
```

### Estado HTTP
```
return new ResponseEntity<>(HttpStatus.NOT_Found);
```

- El estado a devolver dependerá de la operación que se realice y lo que ocurra
- El objeto HttpStatus contiene todos los estados posibles de HTML mediente diversos enumerados
