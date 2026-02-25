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
## 6.Anotación PathVariable

 Existen operaciones que trabajan con todos los datos como por ejemplo: "Obtener todos los datos de peliculas"
 Pero en otras ocasiones únicamente queremos trabajar con un solo dato como por ejemplo:
 
#### -Borrar una película con id "X"
#### -Obtener una película con id "X"
#### -Actualizar una película con id "X"

En estos casos que queremos trabajar con un solo recurso debemos indicar en la ruta un campo que identifique el recurso con el que queremos trabajar
Se utilizar la anotacion @PathVariable
```
public ResponseEntity<Void> borrarPelicula(@PathVariable Long if)
```
```
@GetMapping("/{id}")
public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable Long id){
    Pelicula pelicula = peliculaService.obtenerPelicula(id);
    if (pelicula != null){
         return new ResponseEntity<>(pelicula, HttpStatus.OK);
    }else{
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
```

```
@GetMapping("/")
public ResponseEntity<List<Pelicula>> obtenerPeliculas() {
    List<Pelicula> peliculas = peliculasService.obtenerTodasLasPeliculas();
    if (pelicula != null && !peliculas.isEmpty){
         return new ResponseEntity<>(pelicula, HttpStatus.OK);
    }else{
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
```

## 7.Operación post

Para realizar una operacion POST (insertar un recurso en la BD) necesitamos:

- Crear un método en el controlador
- Encima del método colocar la anotación @PostMapping
- En estos metodos es común que un parámetro sea de tipo @RequestBody
- Utilizar el método del servicio que inserta un dato

## 8.Operación DELETE

Para realizar una operación DELETE (borrar un recurso de la BD) necesitamos:

- Crear un método del controlador
- Encima del método colocar la anotación @DeleteMapping con un párametro que indique cual queremos borrar @DeleteMapping("/{id}")
- En estos métodos es común que un parámetro sea de tipo @PathVariable
- Utilizar el método del servicio que borra un dato

## 8.1.Operación GET sin parametros

Para realizar una operación GET sin parámetros (obtener varios recursos de la BD) necesitamos:
- Crear un método en el controlador
- Encima del método colocar la anotación @GetMapping
- Utilizar el método del servicio que obtiene todos los datos

## 9.Operación GET con parámetros

Para realizar una operación GET con parámetros(obtener uno o varios filtrados de la BD) necesitamos:

- Crear un método en el controlador
- Encima del método colocar la anotación @GetMapping con un parametro que indique cual queremos obtener @GetMapping("/{id}")
- En estos métodos es común que un parametro sea de tipo @PathVariable
- Utilizar un metodo del servicio que obtiene un dato con un id

Tambien podemos no solo obtener por id y utilizar nuestro metodo que obtiene datos como un atributo:

- @GetMapping("/duracionMenorA/{minutos}")
- En este caso nuestro parametro seria @PathVariable int minutos
- Utilizar el metodo del servicio que obtiene un dato dado un atributo

## 10.Operación PUT

Para realizar una operación PUT (actualizar un recurso de la BD) necesitamos:
 n metodo en el controlador
- Encima del metodo colocar la anotación @PutMapping con un parametro que indique cual queremos actualizar @PutMapping("/{id}")
- En estos métodos es comun que un parametro sea de tipo @PathVariable (id) y otro tipo de @RequestParam (atributo a actualizar)
- Utilizar el metodo del servicio que actualiza un dato

## 11.Postman

Postman es una herramienta para desarrollar, probar y documentar APIs
En nuestro caso lo vamos a utilizar para una vez creada la API poder probar sus métodos mandando peticiones HTTP y observar el resultado a través de las respuestas que nos ofrece

La interfaz es muy sencilla. Para probar a hacer una peticion:
##### History--------- New y seleccionar HTTP

Si tenemos en la API una ruta para obtener (GET) un recurso dado un ID podriamos hacer la siguiente petición:
### Peticion:

GET:  http://localhost:8080/peliculas/2

### Respuesta:
En Body---Pretty

```
{
"id": 2,
"titulo": "Piratas del caribe 3",
"director": "Gore Verbinski",
"duracion": 190
}

En caso de que utilicemos @RequestParam debemos rellenar el parametro aqui:

Params-----Query Params
Key---- nuevoTitulo
Value---- Piratas del caribe 3

Y vemos que lo añade a la URL

En caso de que utilicemos @RequestBody debemos rellenar la información aqui:

Body----- raw[x]
```
{
"titulo": "Piratas del caribe 3",
"director": "Gore Verbinski",
"duracion": 190
}
```
