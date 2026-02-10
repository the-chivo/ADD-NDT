/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Practica_7;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author adria
 */
@Service
public class LibroService {
    
    @Autowired   // Permite obtener la informacion de dicho fichero
    private SessionFactory  sessionFactory;
    
    public LibroService(){}
    
    public Long insertarLibro(Libro libro){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            session.persist(libro);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }   finally{
            session.close();
        }
        
        return libro.getId();
    }
    
    
    public void eliminarLibro(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
                   
        try{
            transaction = session.beginTransaction();
            Libro libroId = session.get(Libro.class, id);
            session.remove(libroId);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }   finally{
            session.close();
        }            
    }
    
    public void borrarLibro(Libro libro) {
        Session session = sessionFactory.openSession();
        Transaction ts = null;

        try {
            ts = session.beginTransaction();

            Libro libroBD = session.get(Libro.class, libro.getId());
            if (libroBD != null) {
                session.remove(libroBD);
            }

            ts.commit();
        } catch (Exception e) {
            if (ts != null){
                ts.rollback();
            } 
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void actualizarPaginasLibro(Long id, int nuevasPaginas) {
        Session session = sessionFactory.openSession();
        Transaction ts = null;

        try {
            ts = session.beginTransaction();

            Libro libroBD = session.get(Libro.class, id);
            if (libroBD != null) {
                libroBD.setPaginas(nuevasPaginas);
                session.merge(libroBD);
            }

            ts.commit();
        } catch (Exception e) {
            if (ts != null){
                ts.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void actualizarTituloLibro(Long id, String nuevoTitulo) {
        Session session = sessionFactory.openSession();
        Transaction ts = null;

        try {
            ts = session.beginTransaction();

            Libro libroBD = session.get(Libro.class, id);
            if (libroBD != null) {
                libroBD.setTitulo(nuevoTitulo);
                session.merge(libroBD);
            }

            ts.commit();
        } catch (Exception e) {
            if (ts != null){
                ts.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
     public Libro obtenerLibroPorId(Long id) {
        Session session = sessionFactory.openSession();
        Libro libroBD = null;

        try {
            libroBD = session.get(Libro.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return libroBD;
    }
     
     public List<Libro> obtenerLibrosConMenosPaginas(int paginas) {
        Session session = sessionFactory.openSession();
        List<Libro> libros = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
            Root<Libro> root = cq.from(Libro.class);

            cq.select(root).where(cb.lessThan(root.get("paginas"), paginas));

            libros = session.createQuery(cq).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return libros;
    }
     
     public List<Libro> obtenerLibrosPorAutor(Autor autor) {
        Session session = sessionFactory.openSession();
        List<Libro> libros = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
            Root<Libro> root = cq.from(Libro.class);

            cq.select(root).where(cb.equal(root.get("autor"), autor));

            libros = session.createQuery(cq).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return libros;
    }

}
