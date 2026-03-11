# Tema 9.1

# Introduccion a bases de datos NoSQL

## 1.NoSQL concepto

* Las bases de datos NoSQL que no utilizan el  enfoque tradicional de bases de datos relacionales.
* No utiliza tablas con filas y columnas para almacenar los datos.
* La forma mas comun de almacenar datos es en formato JSON. No es la unica forma.

* NoSQL no es la unica tecnologia, representa a un grupo de productos y conceptos para el almacenamiento de datos:
* Modelo de datos no relacional
* Funciona bien en clusters
* Normalmente son de codigo abierto
* No tienen un esquema de datos fijo

## 1.1 Clúster concepto

Grupo de servidores que trabajan juntos para alojar y gestionar bases de datos en la nube de manera eficiente y escalable. Caracteristicas que deben cumplir:
* #### Escalabilidad:
Horizontalmente o verticalmente
* #### Alta disponibilidad:
incluso ante fallos de red o hardware
* #### Seguridad integrada:
mediante autenticación, cifrado y uso de redes seguras
* #### Rendimiento:
Baja latencia (tiempos de respuesta bajos)
* #### Monitoreo y mantenimiento:
* Incluye herramientas para rastrear étricas y realizar tareas de mantenimineto como copias de seguridad.
* #### Flexibilidad y compatibilidad:
Nodos en varios paises para menor latencia y debe ser compatible con multitud de tecnologias
* #### Consistencia:
Los datos deben ser iguales en todos los nodos
* #### Resiliencia:
Capacidad de recuperarse autromaticamente ante fallos.

### Load Balancer.

Varios nodos (servidores) trabajando como uno solo.Posiblemente ditribuidos por el mundo

Suelen contar con balanceadores de carga:

Es un sistema que distribuye de manera eficiente el trafico entrante entre varios servidores en una red para garantizar una mayor disponibilidad, rendimiento y confiabilidad del sistema

## 1.2 Escalabilidad horizontal vs vertical

La escalabilidad es la capacidad de crecimiento de una aplicación para atender a 
un número cada vez mayor de solicitudes y usuarios sin que la calidad de servicio 
se vea afectada

### Escalabilidad vertical

* Consiste en aumentar los recursos de un servidor existente. Mejorando cualquiera de sus partes como CPU, Ram, almacenamiento, etc.
* Es facil escalar verticalemnte ya que solo consiste en añadir omejorar componentes
* El beneficio y escalado es limitado. Una vez tiene la mejor CPU no puedes mejorarla mas, pero puedes seguir teneindo problemas para atender solicitudes
* Escalar verticalmente suele ser mas caro ya que el hardware especializado lo es

### Escalabilidad horizontal

* Consiste en umentar la cantidad de servidores(nodo) que atienden una aplicacion. Se configuran un grupo de servidores para atender las peticiones de manera conjubnto (cluster) haciendo usp de balanceados de carga.
* Es mas complejo escalar horizontalmente ya que requiere de configuración compleja de los servidores para trabajar como uno solo
* El escalado es practicamente limitado. Puedes seguir añadiendo servidores bajo demanda
* Escalar horizontalmente es mas barato ya que normalmente no se usa hardware especializado ni de ultima generación.

## 2.¿Por que surgieron las bases de datps NoSQL?
Surgieron en respuesta a las limitaciones de las bases de datos relacionales(SQL):

#### Necesidad de manejar grandes volumenes de datos (BIG DATA)
* BD SQL: Dificil escalar horizontalmente y manejar gran cantidad de datos distribuidos
* Con el auge de web 2.0(redes sociales, correo, IOT, etc.) los datps crecieron exponencialmente

#### Flexibilidad de los esquemas de datos
* BD SQL: Utilizan un esquema fijo.(Tablas con columnas)
* BD NoSQL: Datos flexibles

#### Manejo de diferentes tipos de datos
* BD SQL: Tablas
* BD NoSQL: JSON; XML; Grafos, Clave-valor, etc

#### Disponibilidad
* DB NoSQL: Al estar alojadas en cluster si un nodo se cae, otro debe poder atender la solicitud
* BD SQL: Pueden estar alojados en varios servidores pero esto presentan muchos problemas para este tipo de base de datos y es dificil de manejar la consistencia de datos

## 3. Tipos de bases de datos NoSQL

### Bases de datos clave-valor
* Almacenan los datos como pares clave-valor
* Ideales para aplicaciones que requieren búsquedas rapidas de datos por clave
* Casp de uso: sesiones de usuario, caché o configuraciones
* Clave: "user123", Valor: "{'nombre':'Juan', 'email':'juan@email.com', 'rol':'admin'}"

### Bases de datos basadas en documentos

* Almacenan los datos en formato de documentos como JSON, BSON o XML
* Cada documento es flexible y puede tener una estructura diferente
* Caso de uso: aplicaciones con datos no estructurados(no fijos)
* { "_id": "001", "nombre": "Laptop", "precio": 1200, "especificaciones": {"marca": "Dell", "procesador": "Intel i7","memoria": "16GB" } }

### Bases de datos almacenadas en columnas
* Almacenan los datos en columnas en lugar de filas. Cada bloque de datos contiene informacion de una sola columna
* Esto optimiza lasconsultas sobre grandes volumenes de datos.
* Caso de uso: Analisis de grandes cantidades de datos

### Bases de datos basadas en grafos

* Dseñadas para almacenar relaciones entre datos como grafos, con nodos(entidades) y aristas (relaciones)
* Caso de uso: Redes sociales, recomendaciones, gestion de rutas.

## 4.Cuando se suelen utilizar bases de datps NoSQL

* BIG DATA(grandes volumenes de datos)
* Escalabilidad horizontal(se necesita este tipo de escalado)
* Datos semi-estructurados o no estructurados
* Aplicaciones en tiempo real(atlas ops/seg y baja latencia)
* Relaciones complejas entre datos(grafos)
* Alta disponibilidad y tolerancia a fallos
