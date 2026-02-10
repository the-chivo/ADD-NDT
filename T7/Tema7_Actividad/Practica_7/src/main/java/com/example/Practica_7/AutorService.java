/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Practica_7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Practica_7.Autor;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author adria
 */
@Service
public class AutorService {
    
    @Autowired   // Permite obtener la informacion de dicho fichero
    private SessionFactory  sessionFactory;
    
    public AutorService(){}
    
    public Long insertarAutor(Autor autor){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            session.persist(autor);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }   finally{
            session.close();
        }
        
        return autor.getId();
    }
    
    
    public void borrarAutor(Autor autor) {
        Session session = sessionFactory.openSession();
        Transaction ts = null;

        try {
            ts = session.beginTransaction();

            // Obtener la entidad de la BD para que sea "managed"
            Autor autorBD = session.get(Autor.class, autor.getId());
            if (autorBD != null) {
                session.remove(autorBD);
            }

            ts.commit();
        } catch (Exception e) {
            if (ts != null) {
                ts.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }    
       
     public void actualizarNombreAutor(Long id, String nuevoNombre) {
        Session session = sessionFactory.openSession();
        Transaction ts = null;

        try {
            ts = session.beginTransaction();

            Autor autorBD = session.get(Autor.class, id);
            if (autorBD != null) {
                autorBD.setNombre(nuevoNombre);
                session.merge(autorBD);
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
     
    public Autor obtenerAutorPorId(Long id) {
        Session session = sessionFactory.openSession();
        Autor autorBD = null;

        try {
            autorBD = session.get(Autor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return autorBD;
    }

    public List<Autor> obtenerAutoresPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        List<Autor> autores = null;

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
            Root<Autor> root = cq.from(Autor.class);

            cq.select(root).where(cb.like(root.get("nombre"), "%" + nombre + "%"));

            autores = session.createQuery(cq).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return autores;
    }
}