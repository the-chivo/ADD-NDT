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
| Basado en eventos(dispara eventos para saber cuando <br> inicia y cuando termina una etiqueta XML)| Carga todo el fichero en memoria|
| Analiza nodo a nodo: <br> <persona <br> edad="30">Juan</persona> | Permite nuscar tags tanto hacia delante y hacia detras en todo el documento |
| Analiza sobre la marcha sin cargar el fichero en memoria | Almacena el fichero en memoria en forma de arbol |
| Rapido en tiempo de ejecucion | Lento en tiempo de ejecución |
| Solo permite lectura de ficheros XML | Se pueden insertar y/o eliminar nodos |

