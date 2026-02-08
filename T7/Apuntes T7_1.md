# El mapeo relacional

# 1. Mapeo objeto relacional

##### Java(poo) Bases de datos
Clases----------Tablas

| Java(POO) | Bases de datos |
|--------------|--------------|
| Clases <----- |-----> Tablas |
| Objeotos <----- | -----> Filas |
| Atributos <----- | -----> Columnas |





### Java(POO)
```
Public class Usuario{
  private int id;
  private String nombre;
}
```

```
Usuario Juan = new Usuario (1, Juan)
Usuario Manuel = new Usuario (2, Manuel
```

### Bases de datos




|  |  |
|--------------|--------------|
| id | nombre |
| 1  |  Juan |
| 2  |  Manuel |
### Para que sirve
- Guardar un objeto en base de datos
- Complejo por las diferencias
- Nos ayudaremos del “Mapeo Objeto 
Relacional” (ORM) (Framework)
- En lugar de escribir consultas SQL un ORM 
permite manipular las bases de datos 
mediante los objetos de nuestros programas


# 2. Ventajas y desventajas ORMs

| Ventajas  | Desventajas |
|--------------|--------------|
| Rapidez en el desarrollo |Mapeo automático -> Peor 
rendimiento |
| Desarrollo orientado a objetos |Curva de aprendizaje
 |
| Abstracción al no usar sentencias | |
| Mantenimiento sencillo |  |
