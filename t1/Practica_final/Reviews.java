/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Alumno
 */
public class Reviews {
    private String nombrePelicula;
    private String reseña;
    
    public Reviews (String nombrePelicula, String reseña){
        this.nombrePelicula = nombrePelicula;
        this.reseña = reseña;
    }
    
    public String getNombrePelicula(){
        return this.nombrePelicula;
    }
    
     public String getReseña(){
        return this.reseña;
    }
}
