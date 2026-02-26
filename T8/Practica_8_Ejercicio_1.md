# Ejercicio 1: 
En la práctica de los temas 7 y 8 creamos dos clases persistentes con sus servicios 
correspondientes. Para realizar esta práctica deberá crear un controlador relacionado con la 
clase persistente que no contiene la clave externa con el objetivo de construir una API.

## Parte 1. Creación de la clase controller. (1 punto) 
Cree una clase controlador, para ello incluya las anotaciones correspondientes vistas en 
teoría. Deberá establecer ya la ruta base al recurso que ofrecerá este controlador y tener 
como atributo el servicio correspondiente.
![Imagen](images/1.png)

## Parte 2.1 Creación de un método POST. (1 punto)

Dentro de la clase controlador vamos a crear nuestro primer método de la API que nos 
permitirá insertar datos en la base de datos a través de peticiones HTTP. Para ello deberá 
crear un método que cumpla con lo siguiente: 
• Es un método de tipo POST. 
• La ruta a la que se hace petición de inserción es /nombreRecurso donde 
nombreRecurso es el nombre del recurso elegido en la cabecera del controlador (es 
decir, no se añade nada más a la ruta). 
• Recibe por parámetro el objeto JSON que se va a insertar (@RequestBody). 
• Insertará un objeto en la base de datos. 
• Devuelve el id del objeto insertado así como un código HTTP 201.

![Imagen](images/2.png)

## Parte 2.2 Prueba del método POST. (1 punto)
A continuación deberá hacer uso de Postman para crear una petición HTTP que inserte 
un objeto en la base de datos. Antes de realizar esto asegúrese de borrar todo el 
contenido de la base de datos para una mayor claridad en las capturas y borre todo lo 
que se añadió en el método main del proyecto en la práctica anterior. 

![Imagen](images/c3.png)
![Imagen](images/c4.png)

## Parte 3.1 Creación de un método PUT. (1 punto)

Dentro de la clase controlador vamos a crear un método de la API que nos permitirá 
actualizar datos en la base de datos a través de peticiones HTTP. Para ello deberá crear 
un método que cumpla con lo siguiente: 
• Es un método de tipo PUT. 
• La ruta a la que se hace petición de inserción es /nombreRecurso/id donde 
nombreRecurso es el nombre del recurso elegido en la cabecera del controlador e id 
es un parámetro de la URL que indica el id del elemento que vamos a actualizar. 
• Recibe por parámetro el id del elemento que se va a actualizar (@PathVariable) y el 
atributo que se va a actualizar (@RequestParam). 
• Actualizará un objeto en la base de datos identificado por dicho ID y le pondrá un 
nuevo valor de atributo (dependerá del método del servicio). 
• Devuelve el código HTTP 200. 

![Imagen](images/c5.png)
