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

### Ventajas
- Rapidez en el desarrollo
- Desarrollo orientado a objetos
- Abstracción al no usar sentencias
- Mantenimiento sencillo

### Desventajas

- Mapeo automático -> Peor rendimiento
- Curva de aprendizaje

# 3.Herramientas ORM

## ORMs para java

### EBEAN

- Soporte para gran 
cantidad de bases de 
datos: H2, postgreSQL, 
MySQL…
- Versatilidad: consultas 
ORM junto a SQL
- Eficiente y buen 
rendimiento

### IBatis
- Desarrollado por Apache
- Facil aprendizaje de desarrollo
- Únicamente podemos 
realizar consultas ORM

### HIBERNATE

- Más popular y utilizado
- Fácil aprendizaje y desarrollo
- Muy completo, permite sentencias ORM Y SQL(HQL) que mejora la sintaxis SQL y su eficiencia

# 4. Hibernate


| x      | Aplicacion     | x                    |
|--------------|------------------|-------------------------------------|
| .PROPERTIES          | Objetos de persistencia | Mapeo XML     |
| X       | Hibernate     | x   |
| x       | Base de datos     | x |
