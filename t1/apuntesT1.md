# Tema 1. Introduccion al manejo de ficheros

Java.io: Operaciones con ficheros.
Creación, Modidicación, Borrado.

#Tema 2. Definicion y tipos de ficheros

## Definición
Sucesion de bits almacenada en un fichero.
## Tipos
### ACSCII 
Lienas de texto en formato ASCII
### Binarios
Informacion en codigo binario
## 2.1 CLase File(Java.io.File)
### File
Representacion abstracta de un fichero
### Constructor
File (String pathname)
### Ejemplo
File fichero = new File("/Desktop/file.txt)

# Metodos de la clase File

## 2.1. Clase File(Java.io.File)
### Metodo
[boolean] cerateNewFile()
### crear fichero
Crea un fichero nuevo y vacío con la ruta 
indicada en el constructor
### Ejemplo
File fichero = new File(“/Desktop/file.txt”);
fichero.createNewFile();

### metodo 
[boolean] delete()
### Borrar fichero
Elimina el fichero o directorio definido por 
la ruta indicada en el constructor
### Ejemplo
File fichero = new File(“/Desktop/file.txt”);
fichero.delete()
### Metodo
[boolean] mkdir()
### Crear fichero
crea el fichero deseado
### Ejemplo
File fichero = new File(“/Desktop/folder”);
fichero.mkdir();
### metodo
[boolean] mkdirs()
### Crear fichero
Crea el directorio deseado 
incluyendo cualquier directorio padre no existente
### Ejemplo
 File fichero = new File(“/Desktop/folder”);
fichero.mkdirs()
### Metodo
[String] getName()
### Que hace
Devuelve el pathname
### Ejemplo
File fichero = new File(“/Desktop/folder”);
fichero.getName()
### Metodo
[boolean] renameTo(File dest)
### que hace
Renombra el fichero. Puede servir para mover archivos
### Ejemplo
File fichero1 = new File(“/Desktop/fichero1.txt”);
File fichero2 = new File(“/Desktop/fichero2.txt”);
fichero1.renameTo(fichero2)
## Metodo
[boolean] exists()
### Que hace
Comprueba si existe el fichero
### Ejemplo
File fichero = new File(“/Desktop/fichero.txt”);
fichero.exists()
### Ruta absoluta
Ruta completa del recurso desde el directorio raiz
ej: c:/usuario/data/desktop/img.png
### Ruta relativa
Representa una parte de la ruta, se tiene en cuenta directorio actual
ej: desktop/img.png
### Metodo
[String] getPath()
### que hace
Devuelve la ruta relativa
### Ejemplo
 File fichero = new File(“/Desktop/folder”);
fichero.getPath()
### Metodo
[String] getAbsolutePath
### Que hace
devuleve la ruta absoluta
### ejemplo
File fichero = new File(“/Desktop/folder”);
fichero.getAbsolutePath()
### Metodo
[String] getParent()
### que hace
Devuelve el pathname del directorio superior(padre)
### Ejemplo
File fichero = new File(“/Desktop/folder”);
fichero.getParent()
### Metodo
[File[]] listFiles()
### Que hace
Devuelcve un array de Files que representan los ficheros del directorio indicado
### ejemplo
File fichero = new File(“/Desktop/folder”);
fichero.listFiles()
### Metodo
[boolean] canWrite()
[boolean] canRead()
### Que hace
Comprueba si se puede escribir (write) o leer (read) el archivo
### Ejemplo
File fichero = new File(“/Desktop/fichero.txt”);
fichero.canWrite();
fichero.canRead()
## 3 Formas de acceder a un fichero
### Secuencial
Accedemos al fichero carácter a carácter (o 
byte a byte) de forma ordenada desde el 
inicio hasta el final.
### Aleatorio
Nos permite acceder a posiciones concretas de nuestro fichero
# Acceso secuencial mediante bytes
## 3.1 Lectura
### Clase
FileInputStream
### Constructor
 FileInputStream(String name)
 o
 FileInputStream(File file)
 ### Uso
Leer datos en bruto como bytes desde un 
archivo. Es ideal para leer archivos 
binarios.
### Metodo
[int] read()
### Leer
Lee un byt del fichero (en orden). Devuelve -1 si no quedan datos que leer
### ejemplo
FileInputStream entrada = new 
FileInputStream(“desktop/fichero.bin”);
 entrada.read();
 entrada.close()
 ### Clase
 FileOutputStream
 ### Constructor
 FileOutputStream(String name) o FileOutputStream(File file)
 ### Uso
Escribir datos en bruto como bytes a un archivo. Es ideal para escribir archivos 
binarios.
## 3.2 Escritura
### Metodo
write(byte[] b)
### Escribir
Escribe un conjunto de bytes en un fichero
### Ejemplo
 FileOutputStream output = new FileOutputStream(“desktop/fichero.txt”);
 String cadena = “prueba de escritura”;
 
byte [ ] arrayBytes = cadena.getBytes();
output.write(arrayBytes);
output.close();

# Acceso secuencial a ficheros mediante caracteres
## 3.3 Lectura
### Clase
FileReader
### Constructor 
FileReader(String name) o FileReader(File file)
### Uso
 Leer datos de caracteres de un archivo. 
Es adecuado para leer archivos de texto 
como .txt, .xml, .json, etc.
### Metodo 
[int] read()
### Leer
Lee un caracter del fichero (en orden).
Devuelve -1 si no quedan datos que leer
### Ejemplo
FileReader entrada = new FileReader(“desktop/fichero.txt”)
char datos = (char)entrada.read();
entrada.close();

## 3.4
