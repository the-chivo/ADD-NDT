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


| Campo        | Tipo de dato     | Descripción  |    f        |
|--------------|------------------|-------------------------------------|s |
| id           | INT (PK)         | Identificador único del usuario     | s|
| nombre       | VARCHAR(50)      | Nombre del usuario                  |s |
| email        | VARCHAR(100)     | Correo electrónico (único)          | s|
| contraseña   | VARCHAR(255)     | Hash de la contraseña               |w |
| creado_en    | DATETIME         | Fecha de creación del registro      | s|


