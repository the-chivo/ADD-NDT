# 1. Introduccion al manejo de conectores
Definimos conector como una serie de clases y librerías que realizan la labor de unir la capa de nuestra 
aplicación con la capa de base de datos. Este punto intermedio es nuestro conector, y es necesario para 
conectarnos a la base de datos y realizar consultas. 

## 1.1 El desfase objeto-relacional
El concepto desfase objeto–relacional viene en relación a dos puntos: por un lado, tenemos la parte de la 
programación orientada objetos, es decir, el aplicativo, y por otro lado, tenemos la base de datos física. 
Muchas veces, surgen discrepancias debido a que la parte de la bases de datos tienen naturalezas distintas 
en comparación al aplicativo que se trabaja con programación orientada a objetos. A este problema lo 
definimos como desfase objeto-relacional. 
El problema no es otro que las discordancias que surgen cuando trabajamos conjuntamente con una base de 
datos relacional y un aplicativo orientado a objetos. Algunos aspectos importantes del desfase son: 
• Hay bastante diferencia entre los datos que se usan en las bases de datos relacionales y en la 
programación orientada a objetos. En las primeras se usan datos simples, mientras que en la 
orientada a objetos son objetos complejos. 
• Implica realizar distintos diagramas, ya que vamos a tener que realizar una traducción desde los 
objetos del aplicativo Java a la base de datos relacional, por lo tanto, se crearán entidades en ambos 
sitios. Entidades distintas, aunque representen la misma unidad.

## 1.2 Protocolos de acceso a base de datos

Realmente, un conector o driver es una serie de clases implementadas (API) que facilitan la conexión a la 
base de datos asociada. 
Basándonos en el lenguaje SQL, disponemos de dos protocolos de conexión: 
• JDBC (Java Database Connectivity): este protocolo fue desarrollado por Sun. 
• ODBC (Open DataBaseConnectivity): desarrollado por Microsoft. 
Una aplicación debe tener asociado siempre un conector. Cuando estamos desarrollando un aplicativo e 
introducimos un conector, no debemos de preocuparnos de demasiadas cuestiones. No tenemos que conocer 
los aspectos técnicos, ni cómo funcionan en su interior dichas bases de datos. Nos ocuparemos, 
básicamente, de cómo realizar la comunicación y de cómo funcione nuestro aplicativo. 
Si usamos el conector JDBC, por ejemplo, no tendríamos que desarrollar un aplicativo para acceder a una 
base de datos Oracle y otro aplicativo o driver para acceder a una base de datos distinta, sino que nosotros 
desarrollaríamos nuestra aplicación y a la hora de realizar cualquier consulta, el conector interpretaría de una 
forma u otra dependiendo de la base de datos asociada. 
En este punto, nuestro aplicativo necesitaría información de una base de datos. Simplemente utilizando 
dicha librería JDBC e indicando las configuraciones de acceso a cada una de ellas, tendremos acceso a las 
mismas sin preocuparnos del lenguaje interno de cada una. 

# 2. Conexiones: Componentes y tipos
Debido a su extensión en el desarrollo de software, y su extenso uso, nos centraremos en el conector JDBC. 
Dividiremos esta sección en dos puntos: componentes y tipos de conexiones.

## 2.1 Componentes

Podemos destacar cuatro componentes en el conector JDBC: 
• La API de JDBC: con ella tenemos una serie de librerías y clases que nos facilitan el acceso a las 
bases de datos relacionales. También nos brinda la oportunidad de realizar consultas a la base de 
datos. Podemos encontrar estas clases en la paquetería: java.sql y javax.sql. 
• Paquete de pruebas JDBC: estas clases se encargan de validar si un driver pasa los requisitos 
previstos por JDBC. 
• El gestor JDBC: es el encargado de realizar la unión entre nuestra aplicación Java con el driver 
apropiado JDBC. Hay dos formas de realizar dicha operación: 
• Conexión directa 
• A través de un pool de conexiones 
• El puente JDBC-ODBC: facilita el uso de los drivers ODBC como si estuviéramos trabajando 
con JDBC. En relación a la arquitectura de conexión con JDBC, podemos identificar dos tipos 
de arquitectura. 
• Arquitectura en dos capas: nuestra aplicación se conectará a la BDD a través de un driver. Tanto el 
driver como la aplicación deben localizarse en el mismo sistema o máquina.


• Arquitectura en tres capas: nuestro aplicativo enviará las instrucciones a una capa intermedia 
(middleware). Esta capa cogerá la información y la enviará a la base de datos correspondiente 
traduciendo los comandos que el aplicativo haya enviado.

## 2.2 Tipos

Vamos a dar nombre a los distintos tipos de conexiones JDBC disponibles: 
• Driver tipo 1 JDBC-ODBC: este driver usa una API nativa, traduce las llamadas realizadas de JDBC a 
ODBC. Los datos devueltos por la base de datos se traducirán en JDBC cuando sean devueltos. 
• Driver tipo 2 JDBC Nativo: estos drivers están escritos una parte en Java y otra parte, en código 
nativo. Las llamadas al API JDBC son traducidas en llamadas propias de la base de datos relacional 
que tengamos. 
• Driver tipo 3 JDBC net: es un driver de tres capas cuyas solicitudes JDBC están siendo traducidas 
en un protocolo de red en una capa intermedia o middleware. Esta capa intermedia recibirá dichas 
solicitudes y las enviará a la base de datos usando un driver JDBC de tipo 1 o de tipo 2. Cabe 
destacar que es una arquitectura muy flexible. 
• Driver tipo 4 protocolo nativo: este tipo de driver realiza las llamadas mediante el servidor, usando 
el protocolo nativo del mismo. Estos drivers pueden desarrollarse al completo en Java, sin ningún 
problema. Si en el futuro se necesitara hacer un cambio de base de datos, evidentemente, habría que 
desarrollar otro driver nativo adaptado a la nueva base de datos relacional. 

## 3. Configuracion de una conexion en codigo

Una vez vistos los tipos de conexión, los protocolos de acceso, y qué tipo de drivers son los más usados en el 
mercado, pasaremos a línea de código. 
El primer paso sería descargar el driver (suele ser “.jar”) de conexión de la base de datos que vamos a utilizar 
y, a continuación, añadirlo a nuestro proyecto Java o nuestro aplicativo. Vamos a ver un ejemplo de conexión 
en línea de código:

```
private static final String DRIVER = "org.mysql.jdbc.DRIVER";
private static final String URL_CONEXION = "jdbc:mysql://localhost:5432/Pruebas";
```

El primer paso para la conexión de una base de datos externa por medio de un driver de conexión es definir 
algunos literales que nos van a hacer falta, como el literal “Driver”, que hace referencia a la librería que 
hemos añadido a nuestro aplicativo, y la “URL CONEXION”, que hace referencia a la URL donde se alojará la 
información. Estas, podemos definirlas como variables estáticas generales, ya que accederemos a ellas más 
tarde. 
Como estamos realizando una prueba de desarrollo, hemos introducido el código en nuestro método main.

```
public static void main(String args[]) throws SQLException{

final String usuario = "user_db";
final String password = "password_db";
Connection dbConnection = null;
Statement statement = null;
}
```
