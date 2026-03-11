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

Segun el teorema de CAP, las bases de datos pueden clasificar en función de las caracteristicas anteriores. No todas cumplen los mismos puntos. Y como mucho cumplen 2:



 


