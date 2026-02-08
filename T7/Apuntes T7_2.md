# Explorando el mapeo objeto relacional

# 1. Clases persistentes

#### Objetivo
#### Objeto(atributos)<----Almacenar---->Base de datos

#### Las clases persistentes son aquellas que nos permiten guardar la informacion de sus objetos en la base de datos

- Reglas para conseguir una clase persistente
- Deben tener un constructor por defecto
- Deben tener un atributo “id” que hará de clave primaria
- Todos los atributos deben ser privados y tener get( ) y set( )

# 2. Configuración del proyecto


| Java  | Maven |Hibernate | Spring Boot | PostgreSQL |
|--------------|------------------|-------------------------------------|---|--|
| Lenguaje | Gestor de dependencias  | ORM| Framewoek Java|Base de datos|

## Descargar postgresql

#### https://www.postgresql.org/download/

## 1. Aceso a postgreSQL en bash

```
psql postgres
```

## 2. Crear un usuario
````
postgres=# CREATE USER postgres WITH PASSWORD `postgres`;
````

## 3. Crear una base de datos
```
postgres=# CREATE DATABASE acceso_a_datos;
```
## 4 Descargamos DBeaver (Sistema )
#### https://dbeaver.io/

## 5.1 Nos conectamos a la base de datos que acabamos de crear

- Creamos una nueva conexion a base de datos y selecionamos PostgreSQL
- Host: localhost
- Database: acceso_a_datos
- Nombre de usuario: postgres
- Contraseña : postgres

## Nos conectamos a la base de datos que acabamos de crear

## 6 Crea un proyecto de Spring Boot

https://start.spring.io/

## 7. Descargamos el proyecto
## 8. Abrimops el proyecto con Eclipse

## 9. Configuramos la conexion a la base datos

#### El archivo src/main/resources/application.properties debe contener:

```
spring.application.name=practica7_8
spring.datasource.url=jdbc:postgresql://localhost:5532/acceso_a_datos
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

## 10. Configurar la ejecución de la aplicación

- Click derecho en el proyecto y Maven build
- en Goals escibir:
```
spring-boot:run
```

# 3. Ejemplo de clase persistente

## 1. Creamos una clase persistente

```
@Entity
@Table(name="peliculas")
public class Pelicula{

}
```
- @Entity indica que es una clase persistente
- @Table indica que el nombre de la tabla en la base de datos

## 2. Establecemos los atributos(serán columnas de la tabla)

```
@Entity
@Table(name="peliculas")
public class Pelicula{
  public Pelicula(){}

  @iD
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String director;
private int duracion;
}
```

- @Id Indica que atributo es la clave primaria
- @GeneratedValue… Genera automáticamente la clave primaria


## 3. Debemos crear los constructores

```
  private int duracion;
  
  public Pelicula(){
  }
  
  public Pelicula(String titulo, String director, int duracion){
    this.titulo = titulo;
    this.director = director;
    this.duracion;
  }
}
```

