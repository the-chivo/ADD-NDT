import java.io.File;
import java.io.FileWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alumno
 */
public class User {
    
    private String nombre;
    private String contraseña;
    private int codigo;
    
    public User(String nombre, String contraseña, int codigo){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.codigo = codigo;
    }
    
    public String getUserName() {
        return this.nombre;
    }
    
    public String getUserPass() {
        return this.contraseña;
    }
    
     public int getUserID() {
        return this.codigo;
    }

    
}
