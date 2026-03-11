# Tema 9.2 MongoDb y el teorema de CAP

## 1. MongoDB

* Es una base de datos NoSQL orientada a documentos
* Los datos de los documentos se estructuran en formato JSON
* Internamente almacena los datos BSON (Binary JSON)
* Modelo de datos flexible. No requiere de un esquema rigido
* Escalabilidad horizontal. Permite dividir los datos entre nodos para manejar grandes volumenes de información
* Utiliza un sistema de ralizacion llamado "replica sets" donde los datos se duplican entre varios servidores
* Compatible con multiples plataformas. Se puede implementar en local y en la nube

## 2. Cuando utilizar MongoDB

* Aplicaciones que manejan datos no estructurados o semi-estructurados
* Aplicaciones con datos que cambiena frecuentemente
* Aplicaciones donde la escalabilidad y la disponibilidad cpm criticas
* Aplicaciones en tiempo real como logs, chats, comercio electronico, aplicaciones de automoviles, etc

## 3.El teorema de CAP
El teorema de CAP sostiene que en sistemas distribuidos no es posible garantizar al comleto la consistencia, la disponibilidad y la tolerancia

#### Consistencia:
Todos los nodos del sistema tienen los mismos datos en un momento dado. Es decir, una lectura siempre deveulve el valor más reciente o actualizado despues de una escritura
#### Disponibilidad:
El sistema responde a las solicitudes de los usuarios. Cualquier petición recibe una respuesta
#### Tolerancia a particiones:
El sistema sigue funcionando correctamente incluso si hay fallos de comunicacion entre los nodos

#### Segun el teorema de CAP, las bases de datos pueden clasificar en función de las caracteristicas anteriores. No todas cumplen los mismos puntos. Y como mucho cumplen 2:

#### * Consistencia y Tolerancia a Participaciones(AP):
Sacrifica la disponibilidad. Si hay una participacion en la red, el sistema prioriza mantener datos consistentes, pero puede dejar de responder hasta que se resuelva el problema.
Ej: MongoDB

#### * Disponibilidad y Tolerancia a Participaciones(AP):
Sacrifica la consistencia. El sistema sigue respondiendo incluso con un fallo en la comunicacion entre servidores pero puede no devolver los datos más actualizados
EJ: DB NoSQL Grafo

## 3.1 Ejemplo teorema de CAP
#### Si tenemos una aplicacion bancaria:

 #### * (CP)
 Si priorizas consistencia, querras que todos los nodos reflejen inmediatamente el saldo actualizado despues de una transferencia (C), pero si hay una particion de red, el sistema podria no estar disponible para evitar insconsistencia(sacrificio A)
 #### *(AP)
 Si priorizas disponibilidad, permitiras que los usuaruios vean un saldo(aunque pueda ser incorrecto durante una particion de red), asegurandote de que el sistema responda(A), pero sacrificando consistencia(C)
 #### Supongamos que un usuario compra el ultimo articulo en stock en una tienda online:
 * EL usuario conectando al Servidor A realiza la compra  y se actualiza el inventario(cantidad = 0)
 * Debido a una partición de red, el Servidor B no recibe esta actualización a tiempo.
 * Otro usuario conectado al Servidor B tambien intenta comprar el articulo. Como el inventario no se actualizo en el Servidor B, este usuario podría realizar una compra de algo que ya no esta disponible.
#### "Se ha priorizado AP(disponibilidad y tolerancias a participaciones). Pueden ocurrir incosistencias temporales.

## 4. Terminos utilizados en MongoDB
#### * Base de datos(Al igual que en el modelo relacional).

#### * Coleccion(es el equivalente a una tabla):
Es un conjunto de elementos relacionados conceptualmente aunque su estructura no es fija como en una tabla
#### * Documento(es el equivalente a una fila de una tabla):
Es una cantidad fundamental de almacenamiento que representa un registro de datos

## 5. Bases de datos en la nube

Hasta ahora hemos trabjado con bases de datos locales. Estas bases de datos almacenaban la base da datos en nuestro ordenador y la información no era accesible desde otra aplicacion conectada a otra red
Existen bases de datos en la nube. Son bases de datos que se implementan acceden a traves de internet
Son alojadas y gestionadas por otras empresas que ofrecen este servicio.

## 5. Bases de datos en la nube: MongoDB Atlas

* MongoDb Atlas es un servicio de base de datos en la nube que proporciona a las empresas todas las capacidades de MongoDb, sin la complejidad de la gestion de infraestructura.
* El servicio ofrece alta disponibilidad, backup automatizado y opciones de recuperacion ante desastres, asegurando que los datos esten siempre seguros y accesibles
* Una de las ventajas clave de MongoDB Atlas es su escalabilidad automatica, lo que permite a las empresas ajustar sus recursos de base de datos segun la demanda
* Ofrece la posibilidad de alojar una base de datos no relacional en un cluster(conjunto de servidores) global que uncluye un total de 115 paises.
* Con una base de datos en la nube no necesitamos instalar nada en nuestro ordenador
* La base de datos se crea y gestiona en el sitio del proveedor de servicios
* El proveedor de servicios otorga un "string de conexion" para conectar las aplicaciones con esta base de datos.
* En nuestra aplicacion unicamente tenemos que indicar que vamos a conectarnos a una base de datos den la nube e indicamos el string de conexion. Es una cadena que identifica nuestra base de datosy nos identifica como usuarios de la base de datos(auntenticacion)
  

