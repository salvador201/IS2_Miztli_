/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import MapeoBD.Salon;
import MapeoBD.Grupo;
import java.util.HashSet;
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
public class SalonDAO implements SalonDAOint {
     private SessionFactory sessionFactory;
     
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Set<Grupo> getGrupos(Long id){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Salon salon = null;
        try {
            tx = session.beginTransaction();
            salon = (Salon) session.get(Salon.class, id);
           // Fuerza a obtener la lista con los grupos
           if(salon != null){
               Hibernate.initialize(salon.getGrupos());
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
        
        if(salon == null){
            return new HashSet();
        }
        
        return salon.getGrupos();
        
    }
    
}
