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


