# Tema 9. Practica 9

# Ejercicio:

#### Ejercicio: En esta práctica vamos a aprender a utilizar una base de datos en línea (nube) no relacional y veremos como establecer la conexión con nuestra aplicación desarrollada en Java haciendo uso de SpringBoot. Concretamente utilizaremos una base de datos MongoDB haciendo uso de sus SaaS (Software as a service) MongoDB Atlas. 

## Parte 1: Registro en MongoDB Atlas 

En primer lugar, como vamos a utilizar una base de datos en línea haciendo uso de 
MongoDB Atlas, nos dirigimos al siguiente enlace y nos registramos: 
https://www.mongodb.com/cloud/atlas/register. Deberemos rellenar algunos datos, el 
más importante es el lenguaje que vamos a utilizar (Java) y con qué propósito se va a 
utilizar (microservicios (APIs)). 
#### Se me olvido hacer captura

## Parte 2: Creación de un clúster

Para empezar a trabajar con MongoDB Atlas necesitamos crear un clúster.  
Un clúster es un conjunto de servidores que trabajan conjuntamente como uno para 
proporcionar redundancia, escalabilidad y alta disponibilidad en la nube. 
Para ello en el proceso de registro, en el segundo paso tenemos una pantalla que dice 
“Deploy your cluster”. Elegimos “M0” que es un clúster gratuito que ofrece MongoDB 
Atlas para aprender y explorar bases de datos en la nube de este tipo. 
En el nombre del clúster escribimos AccesoADatos y a continuación podemos elegir 
entre varios proveedores, dejamos AWS y en región podémoste dejar la que encontramos 
por defecto. 

