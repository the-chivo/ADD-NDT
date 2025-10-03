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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Alumnos
 */
public class Ejercicio_Final_t1 {

    public static void main(String[] args) throws IOException {
        File directorio = new File("Biblioteca");
        String[] categorias = {"Novela","Ciencia","Poesia","Historia","Arte"};
        String textoNovela = "Don Quijote(1605)- Miguel de Cervantes";
        String textoPoesia = "20 Poemas de amor(1924)-Pablo neruda";
        String textoCiencia = "El origen de las especies(1859)- Charles Darwing";
        
        if(!directorio.exists()){
            directorio.mkdirs();
        }
        for(String categoria : categorias){
            
            File dir = new File(directorio + "/" + categoria);
            File fichero = new File(directorio + "/" + categoria + "/Catalogo.txt");
            if(!dir.exists()){
                dir.mkdirs();
                fichero.createNewFile();
            }
            FileReader fr = new FileReader(dir);
        }   
        
         File novelaCat = new File("Biblioteca/Novela/Catalogo.txt");
         FileOutputStream fos = new FileOutputStream(novelaCat);
         fos.write(textoNovela.getBytes());
         fos.close();
         
         File poesiaCat = new File("Biblioteca/Poesia/Catalogo.txt");
         FileWriter fw = new FileWriter(poesiaCat);
         fw.write(textoPoesia);
         fw.close();
         
         File cienciaCat = new File("Biblioteca/Ciencia/Catalogo.txt");
         RandomAccessFile raf = new RandomAccessFile(cienciaCat, "rws");
         raf.writeBytes(textoCiencia);
         
         raf.seek("El origen de las especies(".length());
         raf.writeBytes("1858");
         raf.seek(0);
         
        }
        
        
}
```
