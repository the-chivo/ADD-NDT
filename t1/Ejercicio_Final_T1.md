Consideraciones:
• Para realiazr esta práctica podrá crear un proyecto Java haciendo uso de un IDE como puede
ser Eclipse o Netbeans o incluso de una web como http://jdoodle.com/.
• Al finalizar la práctica deberá contar con un repositorio de Github contenga los enunciados y
soluciones de los ejercicios.
• Se valorará la limpieza, estructuración y claridad del código (tabulaciones, saltos de líneas,
nombres de variables significativos, etc.)
Ejercicio.
Una biblioteca desea organizar digitalmente sus libros y sesiones de lectura. Implementa en Java
un programa que realice las siguientes acciones, en orden:
1. Crear el directorio principal Biblioteca.
○ Si ya existen, no deben volver a crearse.
○ Al crear cualquier directorio debe mostrarse su ruta absoluta.
2. Crear dentro de Biblioteca las categorías de libros como subdirectorios:
○ Novela, Poesía, Ciencia, Historia, Arte.
○ Si ya existen, no deben volver a crearse.
3. Crear dentro de cada categoría un archivo catalogo.txt. En este archivo se irá registrando
información sobre los libros.
4. Operaciones de escritura y lectura:
○ En Novela/catalogo.txt guardar y leer con bytes: "Don Quijote (1605) - Miguel de
Cervantes".
○ En Poesía/catalogo.txt guardar y leer con caracteres: "Veinte poemas de amor
(1924) - Pablo Neruda".
○ En Ciencia/catalogo.txt guardar y leer con acceso aleatorio: "El origen de las
especies (1859) - Charles Darwin". Luego corregir el año a 1858 sin sobrescribir
todo el contenido.
5. Listar todo el contenido de B
   
```
import java.io.File;

public class Ejercicio_Final_t1 {

    public static void main(String[] args) {
        File directorio = new File("Biblioteca");
        
        if(!directorio.exists()){
            directorio.mkdirs();
        }
        
    }
}
```
