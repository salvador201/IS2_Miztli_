/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import MapeoBD.Alumno;
import MapeoBD.Carrera;
import MapeoBD.Grupo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Marco
 */
public class CarreraDAO implements CarreraDAOint{
     private SessionFactory sessionFactory;
     
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    public Set<Grupo> getGrupos(String nombre){
        
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Carrera carrera = null;
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from Carrera as c where c.nombre_carrera = :variable");
            q.setParameter("variable", nombre);
            List a = q.list();
            carrera = (Carrera) a.get(0);
           // Fuerza a obtener la lista con los grupos
           if(carrera != null){
               Hibernate.initialize(carrera.getGrupos());
           }else{
               System.out.println("HOLA");
           }  
           tx.commit();
        }catch(Exception e){
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally{
            session.close();
        }
        
        if(carrera == null){
            return new HashSet();
        }
        
        return carrera.getGrupos();
    }
    }
    
   
    

