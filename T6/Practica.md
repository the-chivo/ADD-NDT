## Incluya en el fichero “data.sql” las consultas de bases de datos para crear las siguientes tablas:

```
REATE TABLE IF NOT EXISTS usuarios (
	id SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL		
);


CREATE TABLE IF NOT EXISTS productos(
	id SERIAL PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedidos(
	id SERIAL PRIMARY KEY,
	id_usuario INT NOT NULL,
	id_producto INT,
	cantidad INT NOT NULL,
	FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
	FOREIGN KEY (id_producto) REFERENCES productos(id)
);
```

## Incluya una captura de pantalla del gestor H2 donde se vean las tablas creadas:

![Imagen](Images/cap01.PNG)
