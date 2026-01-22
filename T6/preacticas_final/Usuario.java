/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adrian.practica;

/**
 *
 * @author adria
 */
public class Usuario {
    
    private int id;
    private String nombre;
    
    public Usuario(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(){
        this.id = id;
    }
    
    @Override
    public String toString(){ return nombre; } 
    
}
