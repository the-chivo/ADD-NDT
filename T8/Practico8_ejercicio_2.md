# Ejercicio 2: 
En la práctica de los temas 7 y 8 creamos dos clases persistentes con sus servicios 
correspondientes. Para realizar esta práctica deberá crear un controlador relacionado con la 
clase persistente que contiene la clave externa con el objetivo de construir una API.
## 1. Método POST
Deberá crear un método para insertar elementos. - La ruta deberá ser: /recurso dónde “recurso" en mi ejemplo sería sesiones. - En el body de la petición no se incluirá la clave externa. - En un parámetro se mandará el id de la clave externa. - Si no se encuentra el elemento relacionado (película en mi caso) deberá devolver un 
mensaje de error descriptivo así como el código HTTP 404. - Si todo va bien, devuelve el ID y el código 201. 
![Imagen](images/1.png)
