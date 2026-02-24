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
#### NO_CONTENT
La respuesta no envia contenido
#### CREATED
Se ha creado un nuevo recurso en BD
#### NOT_FOUND
No se ha encontrado el recurso
#### OK
Todo ha ido bien

## 5.Pasando la información a la API

#### Las peticiones HTTP que hacen peticiones a las APIs pueden enviar información para insertar algo en la BD, actualizar un dato, etc.
#### Podemos hacerlo de dos formas diferentes:

#### En la URL
Usaremos la anotación @PathVariable

#### En el body de una petición HTTP
Usaremos la anotación @RequestBody

## 5.1.Pasando la informacion a la API a través de la URL

#### Se utilizar este metodo cuando se envía uno o pocos datos simples de la API
```
public ResponseEntity<Void> actualizarPelicula(@PathVariable Long id, @RequestParam String nuevoTitulo)
```

## 5.2. Pasando información a la API a través del body de la petición

#### Se utiliza este metodo cuando se envían datos complejos a la aplicación
```
public ResponseEntity<Long> insertarPelicula(@RequestBody Pelicula pelicula)
```
### 6.Anotación PathVariable
#### Existen operaciones que trabajan con todos los datos como por ejemplo: "Obtener todos los datos de peliculas"
#### Pero en otras ocasiones únicamente queremos trabajar con un solo dato como por ejemplo:
#### -Borrar una película con id "X"
#### -Obtener una película con id "X"
#### -Actualizar una película con id "X"



