package com.example.Practica_7;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AdrianApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AdrianApplication.class, args);

                // Obtenemos los servicios
                AutorService autorService = ctx.getBean(AutorService.class);
                 LibroService libroService = ctx.getBean(LibroService.class);
               

                // 1. Insertar un autor
                Autor autor1 = new Autor("Cervantes");
                Long idAutor1 = autorService.insertarAutor(autor1);

                // 2. Insertar otro autor
                Autor autor2 = new Autor("Lorca");
                Long idAutor2 = autorService.insertarAutor(autor2);

                // 3. Borrar el primer autor
                autorService.borrarAutor(autor1);

                // 4. Obtener autor por id y mostrar por pantalla
                Autor autorBD = autorService.obtenerAutorPorId(idAutor2);
                System.out.println("Autor por ID: " + autorBD.getNombre());

                // 5. Actualizar un atributo del autor
                autorService.actualizarNombreAutor(idAutor2, "Federico García Lorca");

                // 6. Obtener por otro atributo (nombre) y mostrar por pantalla
                List<Autor> autoresPorNombre = autorService.obtenerAutoresPorNombre("Federico");
                autoresPorNombre.forEach(a -> System.out.println("Autor buscado por nombre: " + a.getNombre()));

                

                // 7. Insertar un libro del autor creado
                Libro libro1 = new Libro("Don Quijote", 500, autorBD);
                Long idLibro1 = libroService.insertarLibro(libro1);

                // 8. Insertar otro libro del mismo autor
                Libro libro2 = new Libro("Novelas ejemplares", 300, autorBD);
                Long idLibro2 = libroService.insertarLibro(libro2);

                // 9. Borrar el primer libro
                libroService.borrarLibro(libro1);

                // 10. Obtener libro por id y mostrar por pantalla
                Libro libroBD = libroService.obtenerLibroPorId(idLibro2);
                System.out.println("Libro por ID: " + libroBD.getTitulo());

                // 11. Actualizar un atributo del libro
                libroService.actualizarPaginasLibro(idLibro2, 350);
                libroService.actualizarTituloLibro(idLibro2, "Novelas ejemplares revisadas");

                // 12. Obtener libros por otro atributo (menos de X páginas) y mostrar por pantalla
                List<Libro> librosMenosPaginas = libroService.obtenerLibrosConMenosPaginas(400);
                librosMenosPaginas.forEach(l -> System.out.println("Libro con menos páginas: " + l.getTitulo()));               
                
	}
}
