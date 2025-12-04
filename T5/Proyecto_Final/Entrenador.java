
*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.addt4ef1;

public class Entrenador {

    private int id;
    private String nombre;
    private String raza;
    private int partidos;

    // Constructor

    public Entrenador(String nombre, String raza, int partidos) {
        this.nombre = nombre;          
        this.raza = raza;
        this.partidos = partidos;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
   
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    
    public int getPartidos() { return partidos; }
    public void setPartidos(int n_partidos) { this.partidos = n_partidos; }
    
}
