Ejercicio 1. (0.5 puntos)
Haciendo uso de la clase Java.io.File deberá crear un directorio con el nombre "cine_granada"
dentro de la carpeta "P1" utilizada para esta práctica.
```
import java.io.File;

public class MyClass {
  public static void main(String args[]) {
    
    File dir = new File("/P1/cine_granada");
    dir.mkdirs();
  }
}
```
Ejercicio 2. (0.5 puntos)
Haciendo uso de la clase Java.io.File deberá crear los siguientes directorios dentro de la carpeta
"P1" (no confundir con incluir dentro de la carpeta creada en el ejercicio 1): "Lunes, Martes,
Miércoles, Jueves, Viernes, Sábado, Domingo".

```
import java.io.File;

public class MyClass {
    public static void main(String args[]) {
      
        String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    
        for (String dia : dias){
        
            File dir = new File("P1/" + dia);
            dir.mkdir();
        }
    }
  }
```
Ejercicio 3. (1 punto)
Haciendo uso de la clase Java.io.File deberá mover los siguientes directorios: "Lunes, Martes,
Miércoles, Jueves, Viernes, Sábado, Domingo" dentro de la carpeta "cine_granada".

```
import java.io.File;

public class MyClass {
    public static void main(String args[]) {
      
        String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    
        for (String dia : dias){
        
            File origen = new File("P1/" + dia);
            File destino = new File("p1/cine_granada" + dia);
            origen.renameTo(destino);
        }
    }
  }
```

Ejercicio 4. (1 punto)
Hasta este momento hemos creado los directorios sin realizar ningún tipo de comprobación,
añada al código de los ejercicios 1 y 2 comprobaciones para no crear el directorio si ya existe.

Ejercicio 4.1. Comprobaciones añadidas al ejercicio 1. (0.5 puntos de 1)

```
import java.io.File;

public class MyClass {
  public static void main(String args[]) {
    
    File dir = new File("/P1/cine_granada");
    if(!dir.exists()){
        dir.mkdirs();
    }
  }
}
```

Ejercicio 4.2. Comprobaciones añadidas al ejercicio 2. (0.5 puntos de 1)

```
import java.io.File;

public class MyClass {
    public static void main(String args[]) {
      
        String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    
        for (String dia : dias){
        
            File dir = new File("P1/" + dia);
            if(!dir.exists()){
              dir.mkdir();
            }
        }
  }
}
```
Ejercicio 5. (0.5 puntos)
A partir de la modificación realizada en el ejercicio 4 incluya el código necesario para imprimir por
consola la ruta absoluta de los ficheros o directorios en el momento de crearse. Deberá imprimir
un mensaje como el siguiente "Se ha creado el directorio con ruta absoluta: /…/…/…".

-Primer ejercicio
```
import java.io.File;

public class MyClass {
  public static void main(String args[]) {
    
    File dir = new File("/P1/cine_granada");
    if(!dir.exists()){
        dir.mkdirs();
        System.out.println("se ha creado el directorio con la ruta absoluta: " + dir.getAbsolutePath());
    }
  }
}
```
-Segundo:
```
import java.io.File;

public class MyClass {
    public static void main(String args[]) {
      
        String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    
        for (String dia : dias){
        
            File dir = new File("P1/" + dia);
            if(!dir.exists()){
              dir.mkdir();
              System.out.println("se ha creado el directorio con la ruta absoluta: " + dir.getAbsolutePath());
            }
        }
  }
}
```

Ejercicio 6. (0.5 puntos)
Haciendo uso de uno de los métodos de la clase Java.io.File, liste y muestre por pantalla todos los
archivos del directorio "cine_granada". Deberá mostrar la ruta relativa con el siguiente mensaje:
"Archivos creados hasta ahora:" "ruta relativa: /…/…/…", "ruta relativa: /…/…/…", …


import java.io.File;

public class MyClass {
    public static void main(String args[]) {
      
        String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    
        for (String dia : dias){
        
            File dir = new File("P1/" + dia);
            if(!dir.exists()){
              dir.mkdir();
              System.out.println("se ha creado el directorio con la ruta absoluta: " + dir.getAbsolutePath());
            }
        }
  }
}


Ejercicio 7. (1 punto)
Haciendo uso de la clase Java.io.File deberá crear un archivo llamado "sesiones.txt" dentro de
cada una de las carpetas con nombre: "Lunes, Martes, Miércoles, Jueves, Viernes, Sábado,
Domingo". De esta forma deberán crearse 5 archivos llamados "sesiones.txt".

```
import java.io.File;

public class MyClass {
    public static void main(String args[]) {
      
        String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    
        for (String dia : dias){
            File dir = new File("P1/" + dia + "sesiones.txt");
            if(!dir.exists()){
              dir.mkdir();
              System.out.println("se ha creado el directorio con la ruta absoluta: " + dir.getAbsolutePath());
            }
        }
  }
}

```

Ejercicio 8. (1.5 puntos)
Haciendo uso del método de lectura y escritura secuencial mediante bytes realice lo siguiente:
• Escriba en el fichero "sesiones.txt" del directorio "Lunes": Spiderman (2002): 18:00 - 20:07.
• Lea el fichero completo e imprima por pantalla el contenido.

```
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Addp_1 {
    public static void main(String args[]) throws FileNotFoundException, IOException {
        
        File archivo = new File("p1/cine_granada/Lunes/sesion.txt");
        FileOutputStream fos = new FileOutputStream(archivo);
        
        String texto =  "Spiderman (2002): 18:00 - 20:07";
        fos.write(texto.getBytes());
        
        FileInputStream fis = new FileInputStream(archivo);
        int i;
        while((i = fis.read()) != -1){
            System.out.print((char)i);
        }                                          
  }
}
```

Ejercicio 9. (1.5 puntos)
Haciendo uso del método de lectura y escritura secuencial mediante caracteres realice lo
siguiente:
• Escriba en el fichero "sesiones.txt" del directorio "Martes": Iron Man (2008): 17:00 - 19:06.
• Lea el fichero completo e imprima por pantalla el contenido.

```
public class Addp_1 {
    public static void main(String args[]) throws FileNotFoundException, IOException {
        
        File archivo = new File("p1/cine_granada/Martes/sesion.txt");
        FileOutputStream fos = new FileOutputStream(archivo);
        
        String texto = "Iron Man (2008): 17:00 - 19:06.";
        fos.write(texto.getBytes());
        
        FileInputStream fis = new FileInputStream(archivo);
        int i;
        while((i = fis.read()) != -1){
            System.out.print((char)i);
        }                                          
  }
}
```
