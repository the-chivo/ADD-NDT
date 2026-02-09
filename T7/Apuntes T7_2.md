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
```
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

## 4. Debemos definir los get() y los set()

## 5. Si lanzamos la aplicaciòn veremos que se ha creado la tabla

## 6. Insertar datos:

### Objeto sesión
- Sirve para establecer una conexión con la BD y realizar operaciones
- No ceben mantenerse abiertos mucho tiempo por seguridad. Creación y destrucción cada vez que se utilicen
- Permite insertar, borrar y leer datos

```
@Service
public class PeliculaService {

  @Autowired
  private SessionFactory sessionFactory;

  public PeliculasService(){}

  public void insertarPelicula(Pelicula pelicula){

    Session session = sessionFactory.openSession();
    Transaction transaction = null;

    try{
      transaction = session.beginTransaction();
      session.persist(pelicula);
      transaction.commiit();
    } catch (Exception e){
      if (transaction != null){
        transaction.rollback();
      }
      e.printStackTrace();
    } finally{
      session.close();
    }
  }
}
```
- Un service es una clase que trabaja con una entidad

```
 @Autowired
  private SessionFactory sessionFactory;
```

- SessionFactory nos 
permite obtener la 
configuración de la base 
de datos que hemos 
almacenado en 
application.properties.
La anotación @Autowired 
permite obtener la 
configuración de dicho 
fichero
```
Session session = sessionFactory.openSession();
```
- Creación de la sesión
```
  Transaction transaction = null;

    try{
      transaction = session.beginTransaction();
```
- Indicamos que vamos a iniciar una operación

```
} catch (Exception e){
      if (transaction != null){
        transaction.rollback();
      }
```
- Si cualquier operación falla entonces 
revertimos la operación para evitar 
fallos en la base de datos
```

```
session.persist(pelicula)
```

- Guardamos en base de datos

```
transaction.commit();

- Confirma la operacion

```
@SpringBootApplication
public class Practica78Application{

  public static void main(String[] args){
    ApplicationContext ctx = SpringApplication.run(Practica78Application.class, args);
    Pelicula pelicula = new Pelicula("Piratas del caribe", "Gore Verbinski", 180);
    peliculaService.insertarPelicula(pelicula);
  }
```

 Podemos llamar al método insertarPelicula se la siguiente forma
 ```
peliculaService.insertarPelicula(pelicula);

# 4. Lectura, almacenamiento y modificación de objetos

#### Métodos de la clase session

| Almacenamiento  | Lectura |Borrado |Actualizacion|
|--------------|------------------|-------------------------------------|---|
| .persist(Entity entity)| .get(Class, Long id)  | .delete(Entity entity)|.merge(Entity entity)|

## 5.CriteriaBuilder, CriteriaQuery & Root

- Clase que permite construir consultas más complejas
#### Creamos un criteriaBuilder

```
public List<Pelicula> obtenerPeliculasConDuracionMenorA(int minutos){

  Session session = sessionFactory.oppenSession();
  List<Pelicula> peliculas = null;

  try{
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Pelicula> criteriaQuery = criteriaBuilder.createQuery(Pelicukla.class)
    Root<Pelicula> root = criteriaQuery.from(Pelicula.class)
    criteriaQuery.select(root).where(criteriaBuilder.lessThan(root.get("duration), minutos));
    peliculas = session.createQuery(criteriaQuery).getResultList();
  } catch(Exception e){
    e.printStackTrace();
  } finally{
    session.close();
  }

  return peliculas;
}


```
CriteriaQuery<Pelicula> criteriaQuery = criteriaBuilder.createQuery(pelicula.class);
```
- Clase que permite cosntruir consultas más complejas
- indicamos que vamos a crear una query para la entidad "Pelicula"

```
Root<Pelicula> criteriaQuery.from(Pelicula.class);

- Definimos la raiz de la consulta

```
 criteriaQuery.select(root).where(criteriaBuilder.lessThan(root.get("duration), minutos));
```
-Añadimos las condiciones a la consulta

```
peliculas = session.createQuery(criteriaQuery).getResultList();
```

- Ejecutar la consulta
