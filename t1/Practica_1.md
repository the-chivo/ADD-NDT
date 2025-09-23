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


