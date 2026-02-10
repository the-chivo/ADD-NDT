/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Practica_7;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author adria
 */

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int paginas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {}

    public Libro(String titulo, int paginas, Autor autor) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.autor = autor;
    }

    // Getters y setters
    public Long getId() { 
        return id;
    }

    public String getTitulo() {
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas; 
    }

    public Autor getAutor() { 
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
