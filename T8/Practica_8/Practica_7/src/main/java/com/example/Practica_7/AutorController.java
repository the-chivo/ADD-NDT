/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Practica_7;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adria
 */
@RestController
@RequestMapping("/autores") 
public class AutorController {

    @Autowired
    private AutorService autorService; 
    
    @PostMapping("/autores") 
    public ResponseEntity<Long> insertarAutor(@RequestBody Autor autor) {
        Long id = autorService.insertarAutor(autor);
        
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
    
    @PutMapping("/autores/{id}")
    public ResponseEntity<Void> actualizarAutor(
            @PathVariable Long id, 
            @RequestParam String nuevoNombre) {
        
        autorService.actualizarNombreAutor(id, nuevoNombre);
        return new ResponseEntity<>(HttpStatus.OK); 
    }
    
    
    @GetMapping("/autores/{id}")
    public ResponseEntity<Autor> obtenerAutor(@PathVariable Long id) {
        Autor autor = autorService.obtenerAutorPorId(id);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
    
    @GetMapping("/autores/") 
    public ResponseEntity<List<Autor>> obtenerTodos() {
        List<Autor> lista = autorService.obtenerTodosLosAutores();
        if (lista != null && !lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
    }
    
    @GetMapping("/autores/buscarNombre/{nombre}")
    public ResponseEntity<List<Autor>> buscarPorNombre(@PathVariable String nombre) {
        List<Autor> lista = autorService.obtenerAutoresPorNombre(nombre);
        if (lista != null && !lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}