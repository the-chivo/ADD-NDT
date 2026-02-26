/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Practica_7;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;
    
    @Autowired
    private AutorService autorService;

    @PostMapping("/libros")
    public ResponseEntity<Object> insertar(@RequestBody Libro libro, @RequestParam Long idAutor) {
        Autor autor = autorService.obtenerAutorPorId(idAutor);
        
        if (autor == null) {
            return new ResponseEntity<>("Error: El autor no existe", HttpStatus.NOT_FOUND);
        }
        
        libro.setAutor(autor);
        Long id = libroService.insertarLibro(libro);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

   
    @PutMapping("/{id}/paginas")
    public ResponseEntity<Object> actualizarPaginas(@PathVariable Long id, @RequestParam int nuevasPaginas) {
        Libro libro = libroService.obtenerLibroPorId(id);
        
        if (libro == null) {
            return new ResponseEntity<>("Error: Libro no encontrado", HttpStatus.NOT_FOUND);
        }
        
        libroService.actualizarPaginasLibro(id, nuevasPaginas);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @PutMapping("/{id}/autor/{idAutor}")
    public ResponseEntity<Object> actualizarAutor(@PathVariable Long id, @PathVariable Long idAutor) {
        Libro libro = libroService.obtenerLibroPorId(id);
        if (libro == null) {
            return new ResponseEntity<>("Error: Libro no encontrado", HttpStatus.NOT_FOUND);
        }
        
        Autor nuevoAutor = autorService.obtenerAutorPorId(idAutor);
        if (nuevoAutor == null) {
            return new ResponseEntity<>("Error: El nuevo autor no existe", HttpStatus.NOT_FOUND);
        }
        
        libroService.actualizarAutorLibro(id, nuevoAutor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        boolean borrado = libroService.borrarLibroPorId(id);
        
        if (borrado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: No existe el libro a borrar", HttpStatus.NOT_FOUND);
        }
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerPorId(@PathVariable Long id) {
        Libro libro = libroService.obtenerLibroPorId(id);
        
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: No se encuentra el libro", HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> obtenerTodos() {
        List<Libro> lista = libroService.obtenerTodosLosLibros();        
        if (lista != null && !lista.isEmpty()) {
            
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {          
            return new ResponseEntity<>("Error: No se han encontrado libros en la base de datos", HttpStatus.NOT_FOUND);
        }
    }
}