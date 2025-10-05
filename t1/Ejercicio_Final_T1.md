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
5. Listar todo el contenido de Biblioteca (carpetas y archivos), mostrando sus rutas relativas 
desde Biblioteca.
   
```
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author adria
 */
public class Test {

    public static void main(String[] args) throws IOException {
        File directorio = new File("Biblioteca");
        String[] categorias = {"Novela","Ciencia","Poesia","Historia","Arte"};  //Defino los textos a insertar
        String textoNovela = "Don Quijote(1605)- Miguel de Cervantes";
        String textoPoesia = "20 Poemas de amor(1924)-Pablo neruda";
        String textoCiencia = "El origen de las especies(1859)- Charles Darwing";
        
       
        for(String categoria : categorias){         //Bucle que crea los directorios y archivos
            
            File dir = new File(directorio + "/" + categoria);
            File fichero = new File(directorio + "/" + categoria + "/Catalogo.txt");
            if(!dir.exists()){
                dir.mkdirs();
                fichero.createNewFile();
            }
            
            System.out.println(fichero.getPath());         //Muestra en consola la ruta relativa de todos los ficheros
            
            RandomAccessFile raf = new RandomAccessFile(fichero, "rws");
            String linea;
            while((linea = raf.readLine()) != null){       //Muestra en consola el contenido de los archivos que tengan algo
                
                System.out.println(linea);
            }
            
        }   
        
         File novelaCat = new File("Biblioteca/Novela/Catalogo.txt"); //Añade el texto de novela en su catalogo
         FileOutputStream fos = new FileOutputStream(novelaCat);      
         fos.write(textoNovela.getBytes());
         fos.close();
         
         File poesiaCat = new File("Biblioteca/Poesia/Catalogo.txt"); //Añade el texto de poesia en su catalogo
         FileWriter fw = new FileWriter(poesiaCat);
         fw.write(textoPoesia);
         fw.close();
         
         File cienciaCat = new File("Biblioteca/Ciencia/Catalogo.txt"); //Añade el texto de ciencia en su catalogo
         RandomAccessFile raf = new RandomAccessFile(cienciaCat, "rws");  
         raf.writeBytes(textoCiencia);
         
         raf.seek("El origen de las especies(".length());               // Cambia el año por 1858
         raf.writeBytes("1858");
         raf.seek(0);
         
        }
}
```
