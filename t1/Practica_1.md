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
