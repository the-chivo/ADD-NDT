# Tema 3. Parte 1 <br> Trabajo con ficheros XML
# DOM Y SAX
## 1.Acceso a datos con DOM y SAX
Dom(Document Object Model) y Sax(Simple Api for XML)
 *  Leer (SAX y DOM) y escribir (DOM) fichjero XML
  * Detectar elementos de un fichero XML
  * Verifica si los ficheros son válidos

### 1.Ventajas y desventajas: DOM
#### Ventaja:
- Al leer el fichero crea un arbol formado por nodos en memoria
#### Desventaja:
- Almacena todo el fichero en memoria
- Mas lento que SAX
### 1. Ventajas y desventajas: SAX
#### Ventaja:
- Lee el fichero linea a linea, sin cargar todo el documento en memoria.
#### Desventaja:
- Menos potente que DOM al no conocer todo el documento.
### 1.Recomendacion de uso.
#### DOM:
Para tareas complejas que requieran conocer todo el fichero y tengamos un objetivo claro.
#### SAX:
Para recorrer ficheros secuencialmente y realizar operaciones simples.
### 1.Comparacion
| SAX                               | DOM                |
|-----------------------------------|--------------------|
| Basado en eventos(dispara eventos para sabercuando inicia y cuando termina una etiqueta XML)| Carga todo el fichero en memoria|
| para saber cuando inicia y cuando |                    |
|termina una etiqueta xml)          | Definición de B    |
| Ejemplo de uso A                  | Ejemplo de uso B   |
| Ventaja de A                      | Ventaja de B       |
